package com.gowtham.note_repositories

import com.gowtham.core.ResultState
import com.gowtham.note_datasource.remote.NoteService
import com.gowtham.note_domain.ApiResult

class AuthRepositoryImpl(private val service: NoteService) : AuthRepository {

    override suspend fun loginUser(email: String, password: String):
            ResultState<ApiResult> {
        return ResultState.Loading()
    }

    override suspend fun registerUser(email: String, password: String):
            ResultState<ApiResult> {
           return ResultState.Loading()
    }
}