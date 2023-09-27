package com.playground.mynotes.feature_note.domain.use_case

import com.playground.mynotes.feature_note.domain.model.InvalidNoteException
import com.playground.mynotes.feature_note.domain.model.Note
import com.playground.mynotes.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @kotlin.jvm.Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of note cannot be empty")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("The content of note cannot be empty")
        }
        repository.insertNote(note)
    }

}