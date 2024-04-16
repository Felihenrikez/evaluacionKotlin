package com.example.myapplication.modelo

class ItemMesa(var cantidad:Int, val itemMenu: ItemMenu){

    fun calcularSubTotal():Int= cantidad * itemMenu.precio

}