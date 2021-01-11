package me.blitz.cccandroidtest.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable
import me.blitz.cccandroidtest.model.Estimate

@Dao
interface EstimateDao {

    @Query("SELECT * FROM estimate")
    fun getEstimate(): Flowable<List<Estimate>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(estimate: Estimate): Completable

}