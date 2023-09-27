package com.playground.mynotes.feature_note.data.repository

import com.playground.mynotes.feature_note.data.data_source.NoteDao
import com.playground.mynotes.feature_note.domain.model.Note
import com.playground.mynotes.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImp(
    private val noteDao: NoteDao
) : NoteRepository {

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        return noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return noteDao.deleteNote(note)
    }
}