package me.blitz.cccandroidtest.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import me.blitz.cccandroidtest.model.Estimate

@Dao
interface EstimateDao {

    @Query("SELECT * FROM estimate")
    fun getEstimate(): List<Estimate>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(estimate: Estimate)

}