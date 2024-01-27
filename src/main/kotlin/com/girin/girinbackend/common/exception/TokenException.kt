package com.girin.girinbackend.common.exception

import com.girin.girinbackend.common.error.CustomException
import com.girin.girinbackend.common.error.GlobalErrorCode

object InvalidTokenException : CustomException(
    GlobalErrorCode.INVALID_TOKEN,
) {
    private fun readResolve(): Any = InvalidTokenException
}

object ExpiredTokenException : CustomException(
    GlobalErrorCode.EXPIRED_TOKEN,
) {
    private fun readResolve(): Any = ExpiredTokenException
}

object InternalServerErrorException : CustomException(
    GlobalErrorCode.INTERNAL_SERVER_ERROR,
) {
    private fun readResolve(): Any = InternalServerErrorException
}
