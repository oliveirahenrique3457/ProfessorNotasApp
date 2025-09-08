package com.professornotas.app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.professornotas.app.R
import com.professornotas.app.data.Student

class StudentAdapter(private var items: List<Student>) : RecyclerView.Adapter<StudentAdapter.VH>() {
    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvGrade: TextView = view.findViewById(R.id.tvGrade)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return VH(v)
    }
    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: VH, position: Int) {
        val s = items[position]
        holder.tvName.text = s.name
        holder.tvGrade.text = "Nota: ${'$'}{s.grade}"
    }
    fun update(newItems: List<Student>) {
        this.items = newItems
        notifyDataSetChanged()
    }
}
