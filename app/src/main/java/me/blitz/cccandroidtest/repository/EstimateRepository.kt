package me.blitz.cccandroidtest.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.blitz.cccandroidtest.TAG
import me.blitz.cccandroidtest.db.AppDatabase
import me.blitz.cccandroidtest.model.Estimate

class EstimateRepository(val appDatabase: AppDatabase) {

    init {
        val estimate = Estimate(
            "c574b0b4-bdef-4b92-a8f0-608a86ccf5ab",
            "Placebo Secondary School",
            "32 Commissioners Road East",
            32,
            3,
            "2021-08-22 15:23:54",
            "85a57f85-a52d-4137-a0d1-62e61362f716",
            "85a57f85-a52d-4137-a0d1-62e61362f716",
            "85a57f85-a52d-4137-a0d1-62e61362f716",
        )
        insert(estimate)
    }


    @SuppressLint("CheckResult")
    fun insert(estimate: Estimate) {
        appDatabase.estimateDao().insert(estimate)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Log.d(TAG, "Insert estimate success") },
                { Log.d(TAG, "Insert estimate error") }
            )
    }

    fun getEstimate(): Flowable<List<Estimate>> = appDatabase.estimateDao().getEstimate()

}
