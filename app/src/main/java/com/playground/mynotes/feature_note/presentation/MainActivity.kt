package com.playground.mynotes.feature_note.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import com.playground.mynotes.R
import com.playground.mynotes.feature_note.presentation.note.NotesScreen
import com.playground.mynotes.feature_note.presentation.note.components.NoteItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContent {
//            NotesScreen()
        }
    }
}