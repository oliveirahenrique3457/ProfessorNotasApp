package com.professornotas.app.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.professornotas.app.R
import com.professornotas.app.data.Student
import com.professornotas.app.repo.StudentRepository
import kotlinx.coroutines.launch

class AddStudentActivity : AppCompatActivity() {
    private lateinit var repo: StudentRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        repo = StudentRepository(this)
        val etName = findViewById<EditText>(R.id.etName)
        val etGrade = findViewById<EditText>(R.id.etGrade)
        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val name = etName.text.toString().trim()
            val grade = etGrade.text.toString().toDoubleOrNull() ?: 0.0
            if (name.isEmpty()) {
                android.widget.Toast.makeText(this, "Digite o nome", android.widget.Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            lifecycleScope.launch {
                repo.insert(Student(name = name, grade = grade))
                android.widget.Toast.makeText(this@AddStudentActivity, "Aluno salvo", android.widget.Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
