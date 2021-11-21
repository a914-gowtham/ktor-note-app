package com.gowtham.note_repositories

interface NoteRepository {

    suspend fun insertNote()

    suspend fun updateNote()

    suspend fun deleteNote()

    suspend fun getAllNotes()

}