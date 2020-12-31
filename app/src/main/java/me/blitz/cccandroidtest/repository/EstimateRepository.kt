package me.blitz.cccandroidtest.repository

import me.blitz.cccandroidtest.db.AppDatabase
import me.blitz.cccandroidtest.model.Estimate

class EstimateRepository(appDatabase: AppDatabase) {

    init {
        val estimate = Estimate(
            "c574b0b4-bdef-4b92-a8f0-608a86ccf5ab",
            "Placebo Secondary School",
            "32 Commissioners Road East",
            32,
            3,
            "2020-08-22 15:23:54",
            "85a57f85-a52d-4137-a0d1-62e61362f716",
            "85a57f85-a52d-4137-a0d1-62e61362f716",
            "85a57f85-a52d-4137-a0d1-62e61362f716",
        )
        appDatabase.estimateDao().insert(estimate)
    }

}
