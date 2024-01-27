package com.girin.girinbackend.common.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.girin.girinbackend.common.error.CustomException
import com.girin.girinbackend.common.error.ErrorResponse
import com.girin.girinbackend.common.error.GlobalErrorCode
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: CustomException) {
            e.printStackTrace()
            errorToJson((e.cause as CustomException).globalErrorCode, response)
        } catch (e: Exception) {
            when (e.cause) {
                is CustomException -> {
                    e.printStackTrace()
                    errorToJson((e.cause as CustomException).globalErrorCode, response)
                }

                else -> {
                    e.printStackTrace()
                    errorToJson(GlobalErrorCode.INTERNAL_SERVER_ERROR, response)
                }
            }
        }
    }

    private fun errorToJson(globalErrorCode: GlobalErrorCode, response: HttpServletResponse) {
        response.apply {
            status = globalErrorCode.status
            characterEncoding = StandardCharsets.UTF_8.name()
            contentType = MediaType.APPLICATION_JSON_VALUE
            writer.write(
                objectMapper.writeValueAsString(
                    ErrorResponse(
                        globalErrorCode.status,
                        globalErrorCode.message
                    )
                )
            )
        }
    }
}
