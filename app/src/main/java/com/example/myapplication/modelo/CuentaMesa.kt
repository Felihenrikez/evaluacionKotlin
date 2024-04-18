package com.example.myapplication.modelo


class CuentaMesa( var lista: MutableList<ItemMesa>) {


    fun agregarItemMesa( cantidad:Int,itemMenu:ItemMenu,){
        val repetido = lista.find { it.itemMenu.nombre==itemMenu.nombre}
        if(repetido!= null){
            lista.add(ItemMesa(cantidad,itemMenu))
        }
        else{
            val reemplazo= lista.indexOf<ItemMesa?>(element = repetido)
            val saldo =lista[reemplazo].cantidad
            lista[reemplazo].cantidad= saldo +cantidad


        }


    }
    fun calcularTotalSinPropina():Int{
        var total:Int=0
        for(i in 0 until  lista.size){
            val cantidad=lista[i].cantidad
            val precio =lista[i].itemMenu.precio
            val subtotal =cantidad*precio
            total += subtotal

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
