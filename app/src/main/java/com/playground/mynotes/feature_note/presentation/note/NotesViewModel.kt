package com.playground.mynotes.feature_note.presentation.note

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.playground.mynotes.feature_note.domain.model.Note
import com.playground.mynotes.feature_note.domain.use_case.NoteUseCaseWrapper
import com.playground.mynotes.feature_note.domain.util.NoteOrder
import com.playground.mynotes.feature_note.domain.util.OrderType
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class NotesViewModel @Inject constructor(
    private val noteUseCaseWrapper: NoteUseCaseWrapper
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private var recentlyDeletedNode: Note? = null

    private var getNotesJob: Job? = null

    init {
        getAllNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(noteEvent: NoteEvent) {
        when (noteEvent) {
            is NoteEvent.DeleteNode -> {
                viewModelScope.launch {
                    noteUseCaseWrapper.deleteNoteUseCase(noteEvent.note)
                    recentlyDeletedNode = noteEvent.note
                }
            }
            is NoteEvent.Order -> {
                if (
                    state.value.noteOrder::class == noteEvent.noteOrder::class &&
                    state.value.noteOrder.orderType == noteEvent.noteOrder.orderType
                ) {
                    return
                }
                getAllNotes(noteEvent.noteOrder)

            }
            NoteEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCaseWrapper.addNoteUseCase(recentlyDeletedNode ?: return@launch)
                    recentlyDeletedNode = null
                }
            }
            NoteEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getAllNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        noteUseCaseWrapper.getAllNotesUseCase(noteOrder).onEach {notes ->
            _state.value = state.value.copy(
                notes = notes,
                noteOrder = noteOrder
            )
        }
            .launchIn(viewModelScope)
    }
}