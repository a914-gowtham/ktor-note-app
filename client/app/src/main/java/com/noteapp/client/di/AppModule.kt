package com.noteapp.client.di

import com.gowtham.core.Logger
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
}
