package com.girin.girinbackend.common.exception

import com.girin.girinbackend.common.error.CustomException
import com.girin.girinbackend.common.error.GlobalErrorCode

object UserNotFoundException : CustomException(
    GlobalErrorCode.USER_NOT_FOUND,
) {
    private fun readResolve(): Any = UserNotFoundException
}

object UserExistException : CustomException(
    GlobalErrorCode.USER_EXIST,
) {
    private fun readResolve(): Any = UserExistException
}

object UserPasswordMisMatchException : CustomException(
    GlobalErrorCode.PASSWORD_MIS_MATCH
) {
    private fun readResolve(): Any = UserPasswordMisMatchException
}
