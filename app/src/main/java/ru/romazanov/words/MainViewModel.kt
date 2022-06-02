package ru.romazanov.words

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.romazanov.words.data.AppDatabase
import ru.romazanov.words.data.RoomRepository
import ru.romazanov.words.data.Word

class MainViewModel(application: Application) : ViewModel() {

    private val context = application





    private val db = AppDatabase.getInstance(context)

    private val wordDao = db.getWordDao()

    val wordLIst = wordDao.getAll()


   fun addWord(word: Word) {
        viewModelScope.launch {
           wordDao.addWord(word)
        }
    }

    fun deleteWord(word: Word) {
        viewModelScope.launch {
            wordDao.deleteWord(word)
        }
    }

}