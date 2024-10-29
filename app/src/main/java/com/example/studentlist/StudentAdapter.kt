package com.example.studentlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val students: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private var filteredStudents: List<Student> = students

    fun filter(query: String) {
        filteredStudents = if (query.isEmpty()) {
            students
        } else {
            students.filter {
                it.fullName.contains(query, ignoreCase = true) || it.mssv.contains(query)
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(filteredStudents[position])
    }

    override fun getItemCount(): Int = filteredStudents.size

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val fullNameTextView: TextView = itemView.findViewById(R.id.full_name)
        private val mssvTextView: TextView = itemView.findViewById(R.id.mssv)

        fun bind(student: Student) {
            fullNameTextView.text = student.fullName
            mssvTextView.text = student.mssv
        }
    }
}
