package me.blitz.cccandroidtest

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.blitz.cccandroidtest.db.AppDatabase
import me.blitz.cccandroidtest.model.Estimate
import me.blitz.cccandroidtest.model.Person

class AppRepository(private val appDatabase: AppDatabase) {

    var estimate: Estimate? = null
    var person: Person? = null

    init {
        getEstimatePerson()
    }

    private fun getEstimatePerson() {
        GlobalScope.launch {
            estimate = appDatabase.estimateDao().getEstimate()
            person = appDatabase.personDao().getPerson()

            //TODO finish

        }

    }


}