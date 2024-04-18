package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.modelo.CuentaMesa
import com.example.myapplication.modelo.ItemMenu
import com.example.myapplication.modelo.ItemMesa

class MainActivity : AppCompatActivity() {




    private var etCazuela: EditText? = null
    private var etPastelDeChoclo: EditText? = null
    private var tvTotalCazuela: TextView? = null
    private var tvTotalPastelDeChoclo: TextView? = null
    private var tvTotal: TextView? = null
    private var tvPretotal: TextView? = null
    private var swPropina: Switch? = null
    private var tvPropina: TextView? = null
    private var propina = false

        /* creo que por aca debi borrar alguna linea de codigo
        * ya que no logro iniciar como antes*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        etCazuela = findViewById<EditText?>(R.id.etCazuela)
        etPastelDeChoclo = findViewById<EditText?>(R.id.etPastelDeChoclo)
        tvTotalCazuela = findViewById<TextView>(R.id.tvTotalCazuela)
        tvTotalPastelDeChoclo = findViewById<TextView>(R.id.tvTotalPastelDeChoclo)
        tvTotal = findViewById<TextView>(R.id.tvTotal)
        tvPretotal = findViewById<TextView>(R.id.tvPreTotal)
        swPropina = findViewById<Switch>(R.id.swPropina)
        tvPropina = findViewById<TextView>(R.id.tvPropina)


        val cazuela = ItemMenu("cazuela", 10000)
        val pastelDeChoclo = ItemMenu("pastel de choclo", 12000)
        fun crearLista(): MutableList<ItemMesa> {
            return mutableListOf()
        }
        val lista =crearLista()
        val cuenta = CuentaMesa(lista)


        val TextWatcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                var cantidadCazuela = etCazuela.toString().toIntOrNull()
                if (cantidadCazuela != null) {
                    cuenta.agregarItemMesa(cantidadCazuela, cazuela)
                    val subtotal = cazuela.calcularSubtotal(cantidadCazuela)
                    tvTotalCazuela?.text = "$$subtotal"
                    val pretotal = cuenta.calcularTotalSinPropina()
                    tvPretotal?.text = "$$pretotal"


                }
                var cantidadPastelDeChoclo = etPastelDeChoclo?.toString()?.toIntOrNull()
                if (cantidadPastelDeChoclo != null) {
                    cuenta.agregarItemMesa(cantidadPastelDeChoclo, pastelDeChoclo)
                    var subtotal = pastelDeChoclo.calcularSubtotal(cantidadPastelDeChoclo)
                    tvTotalPastelDeChoclo?.text = "$$subtotal"
                    var pretotal = cuenta.calcularTotalSinPropina()
                    tvPretotal?.text = "$$pretotal"

                    if (propina) {
                        var totalPropina = cuenta.calcularPropina()
                        tvPropina?.text = "$$totalPropina"
                        var total = cuenta.calcularTotalConPropina()
                        tvTotal?.text = "$$total"
                    } else {
                        var total = cuenta.calcularTotalSinPropina()
                        tvTotal?.text = "$$total"
                    }
                }
            }


        }
        etCazuela?.addTextChangedListener(TextWatcher)
        etPastelDeChoclo?.addTextChangedListener(TextWatcher)
        propina
        swPropina?.setOnCheckedChangeListener { buttonView, isChecked ->
            propina = isChecked
        }

    }


    private fun <T> MutableList() {

    }
}











