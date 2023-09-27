package com.playground.mynotes.di

import com.playground.mynotes.feature_note.data.data_source.NoteDatabase
import com.playground.mynotes.feature_note.data.repository.NoteRepositoryImp
import com.playground.mynotes.feature_note.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImp(db.noteDao)
    }
}