package com.example.studentlist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sample student list
        val students = listOf(
            Student("John Doe", "2021001"),
            Student("Jane Smith", "2021002"),
            Student("Alice Johnson", "2021003"),
            Student("Bob Brown", "2021004"),
            Student("Charlie Davis", "2021005"),
            Student("Daniel Evans", "2021006"),
            Student("Eva Garcia", "2021007"),
            Student("Frank Harris", "2021008"),
            Student("Grace Lee", "2021009"),
            Student("Henry Wilson", "2021010")
        )

        // Initialize RecyclerView with the adapter
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        studentAdapter = StudentAdapter(students)
        recyclerView.adapter = studentAdapter

        // Search functionality
        val searchBar = findViewById<EditText>(R.id.search_bar)
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                studentAdapter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
