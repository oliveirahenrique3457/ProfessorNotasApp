package com.professornotas.app.repo

import android.content.Context
import com.professornotas.app.data.AppDatabase
import com.professornotas.app.data.Student

class StudentRepository(context: Context) {
    private val dao = AppDatabase.getInstance(context).studentDao()
    suspend fun getAll() = dao.getAll()
    suspend fun insert(student: Student) = dao.insert(student)
}
