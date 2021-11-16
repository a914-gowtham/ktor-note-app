package com.gowtham.note_domain

data class Note(
    val id:String,
    val noteTitle:String,
    val description:String,
    val date:Long
)