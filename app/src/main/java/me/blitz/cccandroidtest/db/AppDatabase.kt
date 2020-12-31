package me.blitz.cccandroidtest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import me.blitz.cccandroidtest.model.Estimate
import me.blitz.cccandroidtest.model.Person

@Database(entities = [Estimate::class, Person::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
    abstract fun estimateDao(): EstimateDao
}