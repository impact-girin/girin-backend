package com.girin.girinbackend.infra.feign.exception

import com.girin.girinbackend.common.error.CustomException
import com.girin.girinbackend.common.error.GlobalErrorCode

object FeignBadRequestException : CustomException(
    GlobalErrorCode.FEIGN_BAD_REQUEST,
) {
    private fun readResolve(): Any = FeignBadRequestException
}

object FeignNotFoundException : CustomException(
    GlobalErrorCode.FEIGN_NOT_FOUND,
) {
    private fun readResolve(): Any = FeignNotFoundException
}

object FeignUnAuthorizedException : CustomException(
    GlobalErrorCode.FEIGN_UNAUTHORIZED,
) {
    private fun readResolve(): Any = FeignUnAuthorizedException
}

object FeignExpiredTokenException : CustomException(
    GlobalErrorCode.FEIGN_EXPIRED_TOKEN,
) {
    private fun readResolve(): Any = FeignExpiredTokenException
}

object FeignForbiddenException : CustomException(
    GlobalErrorCode.FEIGN_FORBIDDEN,
) {
    private fun readResolve(): Any = FeignForbiddenException
}

object FeignInternalServerErrorException : CustomException(
    GlobalErrorCode.FEIGN_INTERNAL_SERVER_ERROR,
) {
    private fun readResolve(): Any = FeignInternalServerErrorException
}
