package com.poc.model
import androidx.room.Database
import androidx.room.RoomDatabase
import com.poc.utility.DBQuery.DATA_BASE_VERSION

@Database(entities = [Movie::class], version = DATA_BASE_VERSION)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}