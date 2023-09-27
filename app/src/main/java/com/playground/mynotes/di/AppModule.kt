package com.playground.mynotes.di

import android.app.Application
import androidx.room.Room
import com.playground.mynotes.feature_note.data.data_source.NoteDatabase
import com.playground.mynotes.feature_note.data.data_source.NoteDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}