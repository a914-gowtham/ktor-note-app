package com.gowtham.note_datasource.remote

interface NoteService {

    suspend fun login(): String

}