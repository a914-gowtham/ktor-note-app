package com.noteapp.client.di

import com.gowtham.core.Logger
import com.gowtham.note_datasource.remote.NoteService
import com.gowtham.note_datasource.remote.NoteServiceImpl
import com.gowtham.note_repositories.AuthRepository
import com.gowtham.note_repositories.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideDummyValue(): Int {
        return 22
    }

    @Singleton
    @Provides
    fun provideLogger(): Logger {
        return Logger("NoteApp:: ")
    }

    @Singleton
    @Provides
    fun provideNoteService(): NoteService {
        return NoteServiceImpl.build()
    }


    @Singleton
    @Provides
    fun provideAuthRepository(noteService: NoteService): AuthRepository {
        return AuthRepositoryImpl(noteService)
    }
}
