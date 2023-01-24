package com.example.seccion_9_palette_buttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Buttons : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons)

        var btBoton = findViewById<Button>(R.id.btBoton)
        btBoton.setOnClickListener {
            // Codigo que queremos ejecutar a l pulsar el boton
            Toast.makeText(this, "btBoton Pulsado", Toast.LENGTH_SHORT).show()
        }

        var imageBoton = findViewById<ImageButton>(R.id.imageBoton)
        imageBoton.setOnClickListener {
            // Codigo que queremos ejecutar a l pulsar el boton
            Toast.makeText(this, "imageBoton Pulsado", Toast.LENGTH_SHORT).show()
        }

        var cgCondiciones = findViewById<ChipGroup>(R.id.cgCondiciones)
        var chip: Chip
        for (i in 0..cgCondiciones.childCount - 1) {
            chip = cgCondiciones.getChildAt(i) as Chip
            chip.textAlignment = View.TEXT_ALIGNMENT_CENTER
            chip.setOnCloseIconClickListener {
                cgCondiciones.removeView(it)
            }
            chip.setOnClickListener {
                var aux = it as Chip
                Toast.makeText(this, "${it.text} pulsado", Toast.LENGTH_SHORT).show()
            }
        }

        val chipNew = Chip(this)
        chipNew.text = "Opcion"
        chipNew.chipIcon = ContextCompat.getDrawable(this, R.drawable.ic_car)
        chipNew.isChipIconVisible = false
        chipNew.isCloseIconVisible = true
        chipNew.isClickable = true
        chipNew.isCheckable = false

        cgCondiciones.addView(chipNew as View)
        chipNew.setOnCloseIconClickListener { cgCondiciones.removeView(chipNew as View) }

        var rgVacaciones = findViewById<View>(R.id.rgVacaciones) as RadioGroup
        var rb = rgVacaciones.getChildAt(1) as RadioButton
        rgVacaciones.check(rb.id)

        // Checkbox
        var cbSeguro = findViewById<CheckBox>(R.id.checkbox1)
        cbSeguro.isChecked = true

        // ToggleButton
        var toggleNormal : ToggleButton = findViewById(R.id.toggleNormal)
        // Tiene 2 parametros, el primero no se usa
        toggleNormal.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) Toast.makeText(this, "Toggle Activado", Toast.LENGTH_SHORT).show()
            else Toast.makeText(this, "Toggle Desactivado", Toast.LENGTH_SHORT).show()
        }

        // Switch
        var swNormal : Switch = findViewById(R.id.swNormal)
        // Tiene 2 parametros, el primero no se usa
        swNormal.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) Toast.makeText(this, "Switch Activado", Toast.LENGTH_SHORT).show()
            else Toast.makeText(this, "Switch Desactivado", Toast.LENGTH_SHORT).show()
        }

        // FloatinButton
        var fabButton = findViewById<FloatingActionButton>(R.id.floating)
        fabButton.setOnClickListener {
            Toast.makeText(this, "fabButton Pulsado", Toast.LENGTH_SHORT).show()
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            var checked = view.isChecked
            when(view.id) {
                R.id.rbPlaya -> {
                    if (checked) Toast.makeText(this, "Vamos a la playa", Toast.LENGTH_SHORT).show()
                }
                R.id.rbLlanura -> {
                    if (checked) Toast.makeText(this, "Vamos a la llanura", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun onCheckBoxClicked(view: View) {
        if (view is CheckBox) {
            var checked = view.isChecked
            when(view.id) {
                R.id.checkbox1 -> {
                    if (checked) Toast.makeText(this, "Seguro Contratado", Toast.LENGTH_SHORT).show()
                    else Toast.makeText(this, "Seguro Anulado", Toast.LENGTH_SHORT).show()
                }
                R.id.checkbox2 -> {
                    if (checked) Toast.makeText(this, "La reserva podra ser cancelada", Toast.LENGTH_SHORT).show()
                    else Toast.makeText(this, "La reserva NO podra ser cancelada", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}