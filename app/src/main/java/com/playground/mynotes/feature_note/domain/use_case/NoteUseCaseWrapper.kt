package com.playground.mynotes.feature_note.domain.use_case

data class NoteUseCaseWrapper(
    val getAllNotesUseCase: GetAllNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNoteUseCase: AddNoteUseCase
)