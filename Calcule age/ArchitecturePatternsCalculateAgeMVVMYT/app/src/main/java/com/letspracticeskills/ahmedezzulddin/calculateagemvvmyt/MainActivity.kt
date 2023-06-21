package com.letspracticeskills.ahmedezzulddin.calculateagemvvmyt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.letspracticeskills.ahmedezzulddin.calculateagemvvmyt.viewmodel.CalculateAgeViewModel

class MainActivity : AppCompatActivity() {

    lateinit var textViewAge: TextView
    lateinit var editTextName: EditText
    lateinit var editTextAge: EditText
    lateinit var buttonCalculateAge: Button

    private val calculateAgeViewModel: CalculateAgeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewAge = findViewById(R.id.textView_your_age)
        editTextName = findViewById(R.id.editText_name)
        editTextAge = findViewById(R.id.editText_age)
        buttonCalculateAge = findViewById(R.id.button_calculate_age)

        buttonCalculateAge.setOnClickListener {

            val name = editTextName.text.trim().toString()
            val age = editTextAge.text.trim().toString()

            calculateAgeViewModel.calculateAge(name, age).observe(this, Observer { person ->
                textViewAge.text = "${person.name} your age: ${person.age}"
            })

        }

    }
}