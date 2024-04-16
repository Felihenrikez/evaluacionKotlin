package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import com.example.myapplication.modelo.CuentaMesa
import com.example.myapplication.modelo.ItemMesa
import com.example.myapplication.modelo.ItemMenu as ItemMenu

class MainActivity : AppCompatActivity() {


    private fun <T> MutableList(): MutableList<T> {
        TODO("Not yet implemented")
    }
    private var etCazuela:EditText?=null
    private var etPastelDeChoclo:EditText?=null
    private var tvTotalCazuela:TextView?=null
    private var tvTotalPastelDeChoclo:TextView?=null
    private var tvTotal:TextView?=null
    private var tvPretotal:TextView?=null
    private var swPropina:Switch?=null
    private var tvPropina:TextView?=null
    private var propina =false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCazuela = findViewById<EditText?>(R.id.etCazuela)
        etPastelDeChoclo = findViewById<EditText?>(R.id.etPastelDeChoclo)
        tvTotalCazuela =findViewById<TextView>(R.id.tvTotalCazuela)
        tvTotalPastelDeChoclo =findViewById<TextView>(R.id.tvTotalPastelDeChoclo)
        tvTotal = findViewById<TextView>(R.id.tvTotal)
        tvPretotal=findViewById<TextView>(R.id.tvPreTotal)
        swPropina = findViewById<Switch>(R.id.swPropina)
        tvPropina =findViewById<TextView>(R.id.tvPropina)


        val cazuela = ItemMenu("cazuela",10000)
        val pastelDeChoclo= ItemMenu("pastel de choclo",12000)
        var lista = MutableList<ItemMesa>()
        var cuenta = CuentaMesa(lista)



        etCazuela.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {


                val cantidad =etCazuela?.toString()?.toIntOrNull()
                if (cantidad != null) {
                    cuenta.agregarItemMesa(cantidad,cazuela)
                    var subtotal = cazuela.calcularSubtotal(cantidad)
                    tvTotalCazuela.text= "$$subtotal"
                    var pretotal =cuenta.calcularTotalSinPropina()
                    tvPretotal.text = "$$pretotal"
                    if ( propina) {
                        var totalPropina = cuenta.calcularPropina()
                        tvPropina.text = "$$totalPropina"
                        var total = cuenta.calcularTotalConPropina()
                        tvTotal.text= "$$total"
                    }
                    else{
                        var total= cuenta.calcularTotalSinPropina()
                        tvTotal.text="$$total"
                    }

                    }


            }


        })

        etPastelDeChoclo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}


            override fun afterTextChanged(s: Editable?) {

                var cantidad = etPastelDeChoclo?.toString()?.toIntOrNull()
                if (cantidad != null) {
                    cuenta.agregarItemMesa(cantidad,pastelDeChoclo)
                    var subtotal = pastelDeChoclo.calcularSubtotal(cantidad)
                    tvTotalPastelDeChoclo.text = "$$subtotal"
                    var pretotal = cuenta.calcularTotalSinPropina()
                    tvPretotal.text = "$$pretotal"
                    if (propina) {
                        var totalPropina = cuenta.calcularPropina()
                        tvPropina.text = "$$totalPropina"
                        var total = cuenta.calcularTotalConPropina()
                        tvTotal.text = "$$total"
                    } else {
                        var total = cuenta.calcularTotalSinPropina()
                        tvTotal.text = "$$total"
                    }

                }
            }
        })

        }





    }











