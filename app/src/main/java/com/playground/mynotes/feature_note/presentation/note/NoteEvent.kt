package com.playground.mynotes.feature_note.presentation.note

import com.playground.mynotes.feature_note.domain.model.Note
import com.playground.mynotes.feature_note.domain.util.NoteOrder

sealed class NoteEvent {
    data class Order(val noteOrder: NoteOrder) : NoteEvent()
    data class DeleteNode(val note: Note) : NoteEvent()
    object RestoreNote : NoteEvent()
    object ToggleOrderSection : NoteEvent()
}
