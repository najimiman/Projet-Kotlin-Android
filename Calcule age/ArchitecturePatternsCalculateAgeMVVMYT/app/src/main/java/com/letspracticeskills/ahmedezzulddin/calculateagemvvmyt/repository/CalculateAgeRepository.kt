package com.letspracticeskills.ahmedezzulddin.calculateagemvvmyt.repository

import androidx.lifecycle.MutableLiveData
import com.letspracticeskills.ahmedezzulddin.calculateagemvvmyt.model.Person

interface CalculateAgeRepository {

    fun calculateYourAge(name: String, age: String): MutableLiveData<Person>
}