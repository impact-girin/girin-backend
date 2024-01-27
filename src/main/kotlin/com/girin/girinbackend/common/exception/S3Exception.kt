package com.girin.girinbackend.common.exception

import com.girin.girinbackend.common.error.CustomException
import com.girin.girinbackend.common.error.GlobalErrorCode

object SaveImageFailedException : CustomException(
    GlobalErrorCode.SAVE_IMAGE_FAILED
) {
    private fun readResolve(): Any = SaveImageFailedException
}
