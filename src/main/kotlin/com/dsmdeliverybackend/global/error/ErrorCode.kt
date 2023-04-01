package com.dsmdeliverybackend.global.error

import com.dsmdeliverybackend.global.error.response.ErrorResponse

enum class ErrorCode (
    override val status: Int,
    override val message: String
) : ErrorResponse {

    IMAGE_NOT_FOUND(400, "Image Not Found"),
    SAVE_IMAGE_FAILED(400, "Save Image Failed"),
    MESSAGE_SEND_FAILED(400, "Message Send Failed"),

    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),
    PASSWORD_MIS_MATCH(401, "Password Mis Match"),

    USER_NOT_FOUND(404, "User Not Found"),
    SNACK_NOT_FOUND(404, "Snack Not Found"),
    PARCEL_NOT_FOUND(404, "Parcel Not Found"),
    POST_NOT_FOUND(404, "Post Not Found"),
    PRODUCT_NOT_FOUND(404, "Product Not Found"),
    CONCLUSION_NOT_FOUND(404, "Conclusion Not Found"),

    USER_ALREADY_EXIST(409, "User Already Exist"),
    SNACK_ALREADY_EXIST(409, "Snack Already Exist"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")

}