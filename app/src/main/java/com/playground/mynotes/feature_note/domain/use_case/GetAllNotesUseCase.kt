package com.playground.mynotes.feature_note.domain.use_case

import com.playground.mynotes.feature_note.domain.model.Note
import com.playground.mynotes.feature_note.domain.repository.NoteRepository
import com.playground.mynotes.feature_note.domain.util.NoteOrder
import com.playground.mynotes.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllNotesUseCase(
    private val repository: NoteRepository
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getAllNotes().map {
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Color -> it.sortedBy { it.color }
                        is NoteOrder.Date -> it.sortedBy { it.timestamp }
                        is NoteOrder.Title -> it.sortedBy { it.title }
                    }
                }
                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Color -> it.sortedByDescending { it.color }
                        is NoteOrder.Date -> it.sortedByDescending { it.timestamp }
                        is NoteOrder.Title -> it.sortedByDescending { it.timestamp }
                    }
                }
            }
        }
    }
}