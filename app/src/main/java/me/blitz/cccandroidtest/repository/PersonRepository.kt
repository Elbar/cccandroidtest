package me.blitz.cccandroidtest.repository

import me.blitz.cccandroidtest.db.AppDatabase
import me.blitz.cccandroidtest.model.Person

class PersonRepository(appDatabase: AppDatabase) {

    init {
        val person = Person(
            "85a57f85-a52d-4137-a0d1-62e61362f716",
            "Joseph",
            "Sham",
            "joseph.sham@fake.fake",
            "123-456-7890"
        )
        appDatabase.personDao().insert(person)
    }
}
