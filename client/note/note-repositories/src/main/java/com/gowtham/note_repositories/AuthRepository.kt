package com.gowtham.note_repositories

import com.gowtham.core.ResultState
import com.gowtham.note_domain.ApiResult

interface AuthRepository {

    suspend fun loginUser(email: String, password: String) : ResultState<ApiResult>

    suspend fun registerUser(email: String, password: String) : ResultState<ApiResult>
}