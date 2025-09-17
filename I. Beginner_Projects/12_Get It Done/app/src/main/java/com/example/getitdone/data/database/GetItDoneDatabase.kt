package com.example.getitdone.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.getitdone.data.model.Task
import com.example.getitdone.data.model.TaskList

@Database(entities = [Task::class, TaskList::class], version = 3)
abstract class GetItDoneDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    abstract fun getTaskListDao(): TaskListDao

    companion object {

        @Volatile
        private var DATABASE_INSTANCE: GetItDoneDatabase? = null

        private val MIGRATION_2_TO_3 =  object : Migration (2, 3) {

            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("""CREATE TABLE IF NOT EXISTS 'task_list'
                                   (
                                      'task_list_id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                                      'name' TEXT NOT NULL
                                   )""".trimMargin())
            }

        }

        fun getDatabase(context: Context): GetItDoneDatabase {
            // If (we don't have a database) make one! else return the existing one
            return DATABASE_INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    GetItDoneDatabase::class.java,
                    "get-it-done-database"
                )
                    .addMigrations(MIGRATION_2_TO_3)
                    .addCallback(object : Callback() {

                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            // Insert default task list
                            db.execSQL("INSERT INTO task_list (name) VALUES ('Tasks')")
                        }

                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                            // Ensure default task list exists even if onCreate wasn't called
                            db.execSQL("INSERT OR IGNORE INTO task_list (task_list_id, name) VALUES (1, 'Tasks')")
                        }
                    })
                    .build()
                DATABASE_INSTANCE = instance
                instance
            }
        }
    }
}