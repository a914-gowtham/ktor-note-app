package com.gowtham.note_domain

data class ApiResult(
    val success: Boolean= false,
    val message: String= "Something went wrong!",
    val data: ApiData
)

data class ApiData(
    val token: String?,
)