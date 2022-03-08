package com.example.mvvmconcept.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmconcept.model.Student

class DetailViewModel: ViewModel() {
    val studentsLD = MutableLiveData<Student>()

    fun fetch() {
        studentsLD.value = Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
    }
}