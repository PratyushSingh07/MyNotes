package com.playground.mynotes.di

import com.playground.mynotes.feature_note.domain.repository.NoteRepository
import com.playground.mynotes.feature_note.domain.use_case.DeleteNoteUseCase
import com.playground.mynotes.feature_note.domain.use_case.GetAllNotesUseCase
import com.playground.mynotes.feature_note.domain.use_case.NoteUseCaseWrapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun providesNoteUseCaseWrapper(repository: NoteRepository): NoteUseCaseWrapper {
        return NoteUseCaseWrapper(
            getAllNotesUseCase = GetAllNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository)
        )
    }
}