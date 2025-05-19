package com.example.getitdone.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 2)
abstract class GetItDoneDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    companion object {

        @Volatile
        private var DATABASE_INSTANCE: GetItDoneDatabase? = null

        fun getDatabase(context: Context): GetItDoneDatabase {
            // If (we don't have a database) make one! else return the existing one
            return DATABASE_INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    GetItDoneDatabase::class.java,
                    "get-it-done-database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                DATABASE_INSTANCE = instance
                instance
            }
        }
    }
}