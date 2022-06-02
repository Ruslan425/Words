package ru.romazanov.words.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    version = 1,
    entities = [Word::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getWordDao(): WordDao

    companion object {

        private var INSTANCE: AppDatabase? = null

       fun getInstance(context: Context): AppDatabase {
           return if(INSTANCE == null) {
               INSTANCE = Room.databaseBuilder(
                   context,
                   AppDatabase::class.java,
                   "word"
               ).build()
               INSTANCE as AppDatabase
           } else {
               INSTANCE as AppDatabase
           }
       }

    }

}