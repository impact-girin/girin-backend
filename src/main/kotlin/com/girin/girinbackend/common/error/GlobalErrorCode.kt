package com.girin.girinbackend.common.error

enum class GlobalErrorCode(
    val status: Int,
    val message: String,
) {
    BAD_REQUEST(status = 400, message = "Bad Request"),
    SAVE_IMAGE_FAILED(status = 400, message = "Save Image Failed"),
    FEIGN_BAD_REQUEST(400, "Feign Bad Request"),

    FEIGN_UNAUTHORIZED(401, "Feign Unauthorized"),
    INVALID_TOKEN(status = 401, message = "Invalid Token"),
    EXPIRED_TOKEN(status = 401, message = "Expired Token"),
    PASSWORD_MIS_MATCH(status = 401, message = "Password Mis Match"),

    FEIGN_FORBIDDEN(403, "Feign Forbidden."),

    USER_NOT_FOUND(status = 404, message = "User Not Found"),
    FEIGN_NOT_FOUND(404, "Feign Not Found"),
    MOUNTAIN_NOT_FOUND(404, "Mountain Not Found"),
    MOUNTAIN_CLUB_NOT_FOUND(404, "Mountain Club Not Found"),

    USER_EXIST(status = 409, message = "User Exist"),
    ALREADY_PARTICIPATE(409, "Already Participate"),

    FEIGN_EXPIRED_TOKEN(419, "Feign Expired Token."),

    FEIGN_INTERNAL_SERVER_ERROR(500, "Feign Internal Server Error."),
    INTERNAL_SERVER_ERROR(status = 500, message = "Internal Server Error");
}
