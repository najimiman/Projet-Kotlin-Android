package com.letspracticeskills.ahmedezzulddin.calculateagemvvmyt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.letspracticeskills.ahmedezzulddin.calculateagemvvmyt.model.Person
import com.letspracticeskills.ahmedezzulddin.calculateagemvvmyt.repository.CalculateAgeRepository
import com.letspracticeskills.ahmedezzulddin.calculateagemvvmyt.repository.CalculateAgeRepositoryImpl

class CalculateAgeViewModel: ViewModel() {

    val calculateAgeRepo: CalculateAgeRepository = CalculateAgeRepositoryImpl()

    fun calculateAge(name: String, age: String): LiveData<Person>{
        var personMutableLiveData = calculateAgeRepo.calculateYourAge(name, age)
        return personMutableLiveData
    }
}