package com.example.movylistapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [MovieDbModel::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(MultimediaConverter::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getMovieDao(): MovieDao

    companion object {
        private var db: AppDataBase? = null
        private var LOCK = Any()

        fun getInstance(context: Context): AppDataBase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDataBase::class.java,
                        "app_data_base",
                    ).fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }
}