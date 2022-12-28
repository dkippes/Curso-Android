package com.example.seccion8_palettetexts

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tvEjemplo: TextView = findViewById<TextView>(R.id.tvEjemplo)
        tvEjemplo.text = "Texto cambiando desde codigo"
        tvEjemplo.setTextColor(Color.RED)
        tvEjemplo.setTypeface(Typeface.MONOSPACE, Typeface.BOLD)

        tvEjemplo.setOnClickListener {
            if (tvEjemplo.currentTextColor === Color.RED) {
                Toast.makeText(this, "TextView Clicked", Toast.LENGTH_SHORT).show()
                tvEjemplo.setTextColor(Color.GREEN)
            } else {
                Toast.makeText(this, "TextView Clicked", Toast.LENGTH_SHORT).show()
                tvEjemplo.setTextColor(Color.RED)
            }
        }

        var etEjemplo = findViewById<EditText>(R.id.etEjemplo)
        etEjemplo.addTextChangedListener {
            if (etEjemplo.text.length == 0) etEjemplo.setError("Campo vacio")
        }
        etEjemplo.setSelection(3)
        var inicio = etEjemplo.selectionStart
        var fin = etEjemplo.selectionEnd
        etEjemplo.selectAll()

        var autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        var countries: Array<String> = resources.getStringArray(R.array.countries_array)
        var adapter : ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, countries)
        autoCompleteTextView.setAdapter(adapter)

        var multiAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView)
        multiAutoCompleteTextView.setAdapter(adapter)
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    }
}