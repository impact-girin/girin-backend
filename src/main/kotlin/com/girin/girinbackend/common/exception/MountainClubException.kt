package com.girin.girinbackend.common.exception

import com.girin.girinbackend.common.error.CustomException
import com.girin.girinbackend.common.error.GlobalErrorCode

object AlreadyParticipateException : CustomException(
    GlobalErrorCode.ALREADY_PARTICIPATE,
) {
    private fun readResolve(): Any = AlreadyParticipateException
}
