package com.example.myapplication.modelo

class ItemMesa(var cantidad:Int, var itemMenu: ItemMenu){

    fun calcularSubTotal():Int= cantidad * itemMenu.precio
}
