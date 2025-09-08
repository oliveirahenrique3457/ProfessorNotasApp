package com.professornotas.app.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.professornotas.app.R
import com.professornotas.app.data.Student
import com.professornotas.app.repo.StudentRepository
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileWriter

class DashboardActivity : AppCompatActivity() {
    private lateinit var repo: StudentRepository
    private lateinit var tvSummary: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        repo = StudentRepository(this)
        tvSummary = findViewById(R.id.tvSummary)

        findViewById<Button>(R.id.btnOpenList).setOnClickListener {
            startActivity(Intent(this, StudentListActivity::class.java))
        }
        findViewById<Button>(R.id.btnAddStudent).setOnClickListener {
            startActivity(Intent(this, AddStudentActivity::class.java))
        }
        findViewById<Button>(R.id.btnExportCsv).setOnClickListener {
            exportCsv()
        }
        refreshSummary()
    }

    private fun refreshSummary() {
        lifecycleScope.launch {
            val students = repo.getAll()
            val count = students.size
            val avg = if (count==0) 0.0 else students.map { it.grade }.average()
            tvSummary.text = "Resumo: ${'$'}count alunos, média geral: ${'$'}{String.format("%.2f", avg)}"
        }
    }

    private fun exportCsv() {
        lifecycleScope.launch {
            try {
                val students = repo.getAll()
                val file = File(filesDir, "notas_export.csv")
                val fw = FileWriter(file)
                fw.append("Nome,Nota\n")
                for (s in students) {
                    fw.append("${'$'}{s.name},${'$'}{s.grade}\n")
                }
                fw.flush(); fw.close()
                // simple feedback via launching file viewer could be added; for now just toast
                android.widget.Toast.makeText(this@DashboardActivity, "Exportado para: ${'$'}{file.absolutePath}", android.widget.Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                android.widget.Toast.makeText(this@DashboardActivity, "Erro ao exportar: ${'$'}{e.message}", android.widget.Toast.LENGTH_LONG).show()
            }
        }
    }
}
