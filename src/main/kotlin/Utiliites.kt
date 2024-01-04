package src.main.kotlin

import src.main.kotlin.RED
import src.main.kotlin.RESET
import java.util.Scanner

/**
 * Aquesta funció serveix per a llegir un nombre enter
 */
fun readInt(intMin:Int,intMax:Int):Int{
    val scan=Scanner(System.`in`)
    var valorInt=0
    var valorCorrecte:Boolean
    do {
        valorCorrecte=scan.hasNextInt()
        if (!valorCorrecte){
            println(RED +"ERROR: introdueix un nombre enter"+ RESET)
        }else{
            valorInt=scan.nextInt()
            if (valorInt<intMin || valorInt>intMax){
                valorCorrecte=false
                println(RED +"ERROR: introdueix un nombre entre els valors requerits"+ RESET)
            }
        }
        scan.nextLine()
    }while (!valorCorrecte)
    return valorInt
}

/**
 * Aquesta funció serveix per a llegir un nombre decimal
 */
fun readDouble():Double{
    val scan=Scanner(System.`in`)
    var valorDouble=0.0
    var valorCorrecte:Boolean
    do {
        valorCorrecte=scan.hasNextDouble()
        if (!valorCorrecte){
            println(RED +"ERROR: introdueix un nombre decimal"+ RESET)
        }else{
            valorDouble=scan.nextDouble()
            if (valorDouble!=0.05 && valorDouble!=0.10 && valorDouble!=0.20 && valorDouble!=0.50 && valorDouble!=1.0 && valorDouble!=2.0 && valorDouble!=5.0 && valorDouble!=10.0 && valorDouble!=20.0 && valorDouble!=50.0){
                valorCorrecte=false
                println(RED +"ERROR: introdueix un nombre entre els valors requerits"+ RESET)
            }
        }
        scan.nextLine()
    }while (!valorCorrecte)
    return valorDouble
}