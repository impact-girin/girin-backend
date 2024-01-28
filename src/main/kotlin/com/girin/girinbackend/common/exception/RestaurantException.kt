package com.girin.girinbackend.common.exception

import com.girin.girinbackend.common.error.CustomException
import com.girin.girinbackend.common.error.GlobalErrorCode

object RestaurantNotFoundException : CustomException(
    GlobalErrorCode.RESTAURANT_NOT_FOUND,
) {
    private fun readResolve(): Any = RestaurantNotFoundException
}
