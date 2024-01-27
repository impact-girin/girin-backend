package com.girin.girinbackend.common.exception

import com.girin.girinbackend.common.error.CustomException
import com.girin.girinbackend.common.error.GlobalErrorCode

object AlreadyParticipateException : CustomException(
    GlobalErrorCode.ALREADY_PARTICIPATE,
) {
    private fun readResolve(): Any = AlreadyParticipateException
}

object MountainClubNotFoundException : CustomException(
    GlobalErrorCode.MOUNTAIN_CLUB_NOT_FOUND,
) {
    private fun readResolve(): Any = MountainClubNotFoundException
}

object MountainNotFoundException : CustomException(
    GlobalErrorCode.MOUNTAIN_NOT_FOUND,
) {
    private fun readResolve(): Any = MountainNotFoundException
}
