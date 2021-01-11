package me.blitz.cccandroidtest

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.blitz.cccandroidtest.db.AppDatabase
import me.blitz.cccandroidtest.model.Estimate
import me.blitz.cccandroidtest.model.EstimatePerson
import me.blitz.cccandroidtest.model.Person

class AppRepository(private val appDatabase: AppDatabase) {

    var estimate: List<Estimate>? = null
    var person: Person? = null
    var estimatePerson: EstimatePerson? = null

    init {
        getEstimatePerson()
    }

    private fun getEstimatePerson() {
        GlobalScope.launch {
            estimate = appDatabase.estimateDao().getEstimate()
            person = appDatabase.personDao().getPerson()

            estimate?.map { it ->
                person?.let { person ->
                    if (it.createdBy == person.id && it.requestedBy == person.id && it.contact == person.id) {
                        estimatePerson =
                            EstimatePerson(
                                person.id,
                                it.company,
                                it.address,
                                it.number,
                                it.revisionNumber,
                                it.createdDate,
                                it.createdBy,
                                it.requestedBy,
                                it.contact,
                                person.firstName,
                                person.lastName,
                                person.email,
                                person.phoneNumber
                            )
                    }
                }

            }
        }
    }
}