package ru.romazanov.words.data

import androidx.lifecycle.LiveData

class RoomRepository(private val wordDao: WordDao) : Repository {


    override val readData: LiveData<List<Word>>
        get() = wordDao.getAll()


    override suspend fun addWord(word: Word) {
        wordDao.addWord(word)
    }

    override suspend fun deleteWord(word: Word) {
        wordDao.deleteWord(word)
    }
}