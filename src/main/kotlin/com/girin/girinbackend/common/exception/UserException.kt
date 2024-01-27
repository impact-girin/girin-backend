package com.girin.girinbackend.common.exception

import com.girin.girinbackend.common.error.CustomException
import com.girin.girinbackend.common.error.GlobalErrorCode

object UserNotFoundException : CustomException(
    GlobalErrorCode.USER_NOT_FOUND,
) {
    private fun readResolve(): Any = UserNotFoundException
}
