package ru.romazanov.words.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word")
data class Word(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val word: String = ""
)
