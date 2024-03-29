package com.girin.girinbackend.common.error

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalErrorHandler {

    @ExceptionHandler(CustomException::class)
    protected fun customExceptionHandling(e: CustomException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            e.of(),
            HttpStatus.valueOf(e.globalErrorCode.status)
        )
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException::class)
    protected fun handleBindException(e: BindException): ValidationErrorResponse? = e.of()

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    protected fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): ValidationErrorResponse? =
        e.of()

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException::class)
    protected fun handleDataIntegrityViolationException(e: DataIntegrityViolationException): ErrorResponse? = e.of()

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException::class)
    protected fun handleIllegalArgumentException(e: IllegalArgumentException): ErrorResponse? = e.of()
}
