package com.gowtham.note_repositories

import com.gowtham.core.ResultState
import com.gowtham.note_domain.ApiResult

class AuthRepositoryImpl(noteService: NoteService) : AuthRepository {

    override suspend fun loginUser(email: String, password: String):
            ResultState<ApiResult> {
        return ResultState.Loading()
    }

    override suspend fun registerUser(email: String, password: String):
            ResultState<ApiResult> {
           return ResultState.Loading()
    }
}