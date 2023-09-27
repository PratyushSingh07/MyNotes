package com.playground.mynotes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.playground.mynotes.ui.theme.*

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val colorOfNotes = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
