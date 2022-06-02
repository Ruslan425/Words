package ru.romazanov.words.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface WordDao {

    @Query("SELECT * FROM word")
    fun getAll(): LiveData<List<Word>>

    @Insert
    suspend fun addWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)


}