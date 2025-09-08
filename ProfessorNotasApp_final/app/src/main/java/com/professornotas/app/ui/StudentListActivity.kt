package com.professornotas.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.professornotas.app.R
import com.professornotas.app.repo.StudentRepository
import kotlinx.coroutines.launch

class StudentListActivity : AppCompatActivity() {
    private lateinit var repo: StudentRepository
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)
        repo = StudentRepository(this)
        adapter = StudentAdapter(emptyList())
        val rv = findViewById<RecyclerView>(R.id.rvStudents)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
        load()
    }

    private fun load() {
        lifecycleScope.launch {
            val students = repo.getAll()
            adapter.update(students)
        }
    }
}
