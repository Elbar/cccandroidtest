package me.blitz.cccandroidtest.repository

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.blitz.cccandroidtest.TAG
import me.blitz.cccandroidtest.db.AppDatabase
import me.blitz.cccandroidtest.model.Person

class PersonRepository(val appDatabase: AppDatabase) {

    init {
        val person = Person(
            "85a57f85-a52d-4137-a0d1-62e61362f716",
            "Joseph",
            "Sham",
            "joseph.sham@fake.fake",
            "123-456-7890"
        )
        insert(person)
    }

    @SuppressLint("CheckResult")
    fun insert(person: Person) {
        appDatabase.personDao().insert(person)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Log.d(TAG, "Insert person success") },
                { Log.d(TAG, "Insert person error") }
            )
    }

    fun getPerson(): Flowable<Person> = appDatabase.personDao().getPerson()
}