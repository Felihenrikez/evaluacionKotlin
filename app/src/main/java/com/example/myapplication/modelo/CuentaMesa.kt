package com.example.myapplication.modelo

import java.time.temporal.ValueRange


class CuentaMesa( var lista:MutableList<ItemMesa>) {


    fun agregarItemMesa( cantidad:Int,itemmenu:ItemMenu,){
        val repetido = lista.find { it.itemMenu.nombre==itemMesa.itemMenu.nombre}
        if(repetido!= null){
            lista.add(itemMesa)
        }
        else{
            val anterior= repetido?.cantidad
            val mas = itemMesa.cantidad
            if (anterior != null) {
                repetido.cantidad= anterior+mas
            }


        }


    }
    fun calcularTotalSinPropina():Int{
        var total:Int=0
        for(item in lista){
            val x:Int= ItemMenu.precio *cantidad

            total += x



        }
        return total


    }
    fun calcularPropina():Int{
        val subtotal =calcularTotalSinPropina()
        return (subtotal* 0.1).toInt()


    }
    fun calcularTotalConPropina():Int{
        val subtotal=calcularTotalSinPropina()
        return (subtotal*1.1).toInt()

    }
}
