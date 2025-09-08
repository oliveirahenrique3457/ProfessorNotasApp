package com.professornotas.app.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Query("SELECT * FROM students ORDER BY name")
    suspend fun getAll(): List<Student>

    @Insert
    suspend fun insert(student: Student)
}
