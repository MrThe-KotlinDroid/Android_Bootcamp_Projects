package com.example.getitdone.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.getitdone.data.model.Task
import com.example.getitdone.data.model.TaskList

@Database(entities = [Task::class, TaskList::class], version = 3)
abstract class GetItDoneDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    abstract fun getTaskListDao(): TaskListDao

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
                    .build()
                DATABASE_INSTANCE = instance
                instance
            }
        }
    }
}