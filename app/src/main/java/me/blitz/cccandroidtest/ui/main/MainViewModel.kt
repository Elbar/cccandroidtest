package me.blitz.cccandroidtest.ui.main

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.blitz.cccandroidtest.model.Person
import me.blitz.cccandroidtest.repository.EstimateRepository
import me.blitz.cccandroidtest.repository.PersonRepository


class MainViewModel(val estimateRepo: EstimateRepository, val personRepo: PersonRepository) :
    ViewModel() {

    val firstName: ObservableField<String> = ObservableField()
    val lastName: ObservableField<String> = ObservableField()
    val fullName: ObservableField<String> = ObservableField()
    val estNumber: ObservableField<String> = ObservableField()
    val revisionNumber: ObservableField<String> = ObservableField()
    val created: ObservableField<String> = ObservableField()
    val company: ObservableField<String> = ObservableField()
    val address: ObservableField<String> = ObservableField()

    init {
        getPerson()
    }

    fun getPerson() =
        personRepo.getPerson()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { person -> getEstimate(person) }
            .subscribe()

    fun getEstimate(person: Person) =
        estimateRepo.getEstimate()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                val personId = person.id
                it.forEach {
                    if (personId == it.createdBy && personId == it.requestedBy && personId == it.contact) {
                        firstName.set(person.firstName)
                        lastName.set(person.lastName)
                        fullName.set(person.firstName + " " + person.lastName)
                        estNumber.set(it.number.toString())
                        revisionNumber.set(it.revisionNumber.toString())
                        created.set(it.createdDate)
                        company.set(it.company)
                        address.set(it.address)
                    }
                }

            }
            .subscribe()
}
