package ru.romazanov.words.data

import androidx.lifecycle.LiveData

interface Repository {

    val readData: LiveData<List<Word>>

    suspend fun addWord(word: Word)

    suspend fun deleteWord(word: Word)

}