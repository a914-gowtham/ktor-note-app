package com.gowtham.core

sealed class ResultState<T> {
    class Success<T>(data: T) : ResultState<T>()
    class Error<T>(message: String) : ResultState<T>()
    class Loading<T> : ResultState<T>()
}