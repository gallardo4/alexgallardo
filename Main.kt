fun main() {
    do {
        val bitlletPreu = calcularPreuFinalBitllet(bitlletDesitjat())
        println(YELLOW+"El preu del teu bitllet és de ${bitlletPreu}€"+RESET)
        println()
        val bitlletCompra = comprarBitllet(bitlletPreu)
        println(YELLOW+"Has pagat "+bitlletCompra+"€"+RESET)
        println()
        val canviDiners = bitlletCompra-bitlletPreu
        println(YELLOW+"El teu canvi és de $canviDiners€"+RESET)
        println()
        println(YELLOW+"S'està imprimint el teu bitllet"+RESET)
        if (canviDiners!=0.0) println(YELLOW+"Pot vosté agafar el seu canvi"+RESET)
        println()
        val volTiquet = preguntarVolTiquet(CYAN+"Vol tiquet (1 - sí, 2 - no)?"+RESET)
        if (volTiquet) println()
        if (volTiquet) imprimirTiquet(bitlletPreu,bitlletCompra,canviDiners)
        println()
        println(CYAN+" #####  ######     #     #####  ### #######  #####     ######  ####### ######     #          #        #####  ####### #     #    #        #####  ####### #     # ######  ######     #    \n" +
                "#     # #     #   # #   #     #  #  #       #     #    #     # #       #     #    #         # #      #     # #       #     #   # #      #     # #     # ##   ## #     # #     #   # #   \n" +
                "#       #     #  #   #  #        #  #       #          #     # #       #     #    #        #   #     #       #       #     #  #   #     #       #     # # # # # #     # #     #  #   #  \n" +
                "#  #### ######  #     # #        #  #####    #####     ######  #####   ######     #       #     #     #####  #####   #     # #     #    #       #     # #  #  # ######  ######  #     # \n" +
                "#     # #   #   ####### #        #  #             #    #       #       #   #      #       #######          # #        #   #  #######    #       #     # #     # #       #   #   ####### \n" +
                "#     # #    #  #     # #     #  #  #       #     #    #       #       #    #     #       #     #    #     # #         # #   #     #    #     # #     # #     # #       #    #  #     # \n" +
                " #####  #     # #     #  #####  ### #######  #####     #       ####### #     #    ####### #     #     #####  #######    #    #     #     #####  ####### #     # #       #     # #     # "+RESET)
        println()
    }while (bitlletCompra!=4321.0)
}

/**
 * Aquesta funció serveix per a demanar a l'usuari quin és el seu bitllet desitjat
 */
fun bitlletDesitjat():Int{
    println(CYAN+"Quin bitllet desitja adquirir?"+RESET)
    println(PURPLE+"1 - Bitllet senzill"+RESET)
    println(PURPLE+"2 - TCasual"+RESET)
    println(PURPLE+"3 - TUsual"+RESET)
    println(PURPLE+"4 - TFamiliar"+RESET)
    println(PURPLE+"5 - TJove"+RESET)
    return readInt(1,5)
}

/**
 * Aquesta funció server per a poder dir quin és el bitllet escollit per l'usuari
 */
fun bitlletEscollit(bitlletDesitjat:Int):String{
    var bitlletEscollit=""
    when(bitlletDesitjat){
        1 -> bitlletEscollit="bitllet senzill"
        2 -> bitlletEscollit="TCasual"
        3 -> bitlletEscollit="TUsual"
        4 -> bitlletEscollit="TFamiliar"
        5 -> bitlletEscollit="TJove"
    }
    return bitlletEscollit
}

/**
 * Aquesta funció serveix per a demanar a l'usuari quina és la seva zona desitjada
 */
fun zonaDesitjada():Int{
    println(CYAN+"Quina zona vol viatjar?"+RESET)
    println(PURPLE+"1"+RESET)
    println(PURPLE+"2"+RESET)
    println(PURPLE+"3"+RESET)
    return readInt(1,3)
}

/**
 * Aquesta funció serveix per a calcular el preu inicial del bitllet segons la zona desitjada
 */
fun calcularPreuInicialBitllet(zonaDesitjada:Int):Double{
    var preuBitllet=0.0
    when (zonaDesitjada){
        1 -> preuBitllet=1.0
        2 -> preuBitllet=1.3125
        3 -> preuBitllet=1.8443
    }
    return preuBitllet
}

/**
 * Aquesta funció serveix per a calcular el preu final del bitllet tenint també en compte el tipus de bitllet escollit
 */
fun calcularPreuFinalBitllet(bitlletDesitjat:Int):Double{
    var preuBitlletFinal=0.0
    val zona=zonaDesitjada()
    val bitllet=bitlletEscollit(bitlletDesitjat)
    when(bitlletDesitjat){
        1 -> preuBitlletFinal=calcularPreuInicialBitllet(zona)*2.4
        2 -> preuBitlletFinal=calcularPreuInicialBitllet(zona)*11.35
        3 -> preuBitlletFinal=calcularPreuInicialBitllet(zona)*40.0
        4 -> preuBitlletFinal=calcularPreuInicialBitllet(zona)*10.0
        5 -> preuBitlletFinal=calcularPreuInicialBitllet(zona)*80.0
    }
    println(YELLOW+"Ha escollit la opció: $bitllet, zona $zona"+RESET)
    return preuBitlletFinal
}

/**
 * Aquesta funció serveix perquè l'usuari afegeixi els diners per a poder comprar el bitllet
 */
fun comprarBitllet(preuBitllet:Double):Double{
    var preuCompra=0.0
    println(CYAN+"Introdueix els diners d'un en un (0.05€, 0.10€, 0.20€, 0.50€, 1€, 2€, 5€, 10€, 20€, 50€):"+RESET)
    do {
        val dinersAfegits=readDouble()
        preuCompra+=dinersAfegits
    }while (preuCompra<preuBitllet)
    return preuCompra
}

/**
 * Aquesta funció serveix per demanar a l'usuari si vol tiquet de la compra
 */
fun preguntarVolTiquet(missatge:String):Boolean{
    val volTiquet:Boolean
    println(missatge)
    val respostaUsuari=readInt(1,2)
    if (respostaUsuari==1) volTiquet=true
    else volTiquet=false
    return volTiquet
}

/**
 * Aquesta funció serveix per imprimir el tiquet de la compra de l'usuari
 */
fun imprimirTiquet(preuDelBitllet:Double,quantitatPagada:Double,canviRetornar:Double){
    println(BLUE+"TIQUET DE LA COMPRA"+RESET)
    println(BLUE+"EL PREU DEL BITLLET ÉS DE $preuDelBitllet€"+RESET)
    println(BLUE+"HA PAGAT VOSTÉ $quantitatPagada€"+RESET)
    println(BLUE+"EL TOTAL A RETORNAR ÉS DE $canviRetornar€"+RESET)
}