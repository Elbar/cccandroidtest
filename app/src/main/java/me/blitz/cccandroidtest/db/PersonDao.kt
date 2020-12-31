package me.blitz.cccandroidtest.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import me.blitz.cccandroidtest.model.Person

@Dao
interface PersonDao {

    @Query("SELECT * FROM person")
    fun getPerson(): Person

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(person: Person)

}