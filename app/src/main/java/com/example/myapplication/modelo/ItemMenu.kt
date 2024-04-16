package com.example.myapplication.modelo

class ItemMenu(val nombre:String,val precio:Int) {

    fun calcularSubtotal(cantidad:Int):Int =precio*cantidad

}
