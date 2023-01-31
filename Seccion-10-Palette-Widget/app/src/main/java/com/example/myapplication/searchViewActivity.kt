package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView

class searchViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view)

        // SEARCH VIEW
        val users = arrayOf("Alberto", "Pepe", "Roberta", "Barometro")
        val adapterUsers: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        var lvUsers = findViewById<ListView>(R.id.lvUsers)
        var svUsers = findViewById<SearchView>(R.id.svUsers)

        lvUsers.adapter = adapterUsers // Se va acomodando - adaptado a las consultas
        svUsers.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                svUsers.clearFocus()
                if (users.contains(query)) adapterUsers.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                adapterUsers.filter.filter(query)
                return false
            }
        })
    }
}