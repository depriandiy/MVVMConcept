package com.example.mvvmconcept.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmconcept.R
import com.example.mvvmconcept.model.Student
import com.example.mvvmconcept.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.student_list_item.*

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var detailStudent: Student

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.studentsLD.observe(viewLifecycleOwner) {
            detailStudent = Student(
                viewModel.studentsLD.value?.id,
                viewModel.studentsLD.value?.name,
                viewModel.studentsLD.value?.dob,
                viewModel.studentsLD.value?.phone,
                viewModel.studentsLD.value?.photoURL
            )
            editID.setText(detailStudent.id)
            editName.setText(detailStudent.name)
            editDOB.setText(detailStudent.dob)
            editPhone.setText(detailStudent.phone)
        }
    }

}