package compras

import kotlin.system.exitProcess

class Menu {

    private val listaDeCompras = ArrayList<Alimentos>()
    private var qtdVerduras = 0
    private var qtdLegumes = 0
    private var qtdGraos = 0
    private var qtdOutros = 0

    fun escolherTipoAlimento(){
        try {
            println("--------------------------------------------------")
            println("Qual tipo de alimento deseja incluir na sua lista?")
            println("[1] VERDURA")
            println("[2] LEGUMES")
            println("[3] GRÃOS")
            println("[4] OUTROS")
            print("Digite o nº da opção escolhida: ")
            when(readln().toInt()){
                1 -> {
                    val verdura = Verdura()
                    cadastrarAlimento(verdura)
                    qtdVerduras += 1
                    continuarLista()
                }
                2 -> {
                    val legume = Legume()
                    cadastrarAlimento(legume)
                    qtdLegumes += 1
                    continuarLista()
                }
                3 -> {
                    val grao = Grao()
                    cadastrarAlimento(grao)
                    qtdGraos += 1
                    continuarLista()
                }
                4 -> {
                    val outro = OutroAlimento()
                    cadastrarAlimento(outro)
                    qtdOutros += 1
                    continuarLista()
                }
                else -> {
                    println("--------------------------------------------------")
                    println("          * Tipo de alimento inválido *           ")
                    escolherTipoAlimento()
                }
            }
        }
        catch (ex: IllegalArgumentException){
            println("--------------------------------------------------")
            println("          * Tipo de alimento inválido *           ")
            escolherTipoAlimento()
        }



    }

    private fun cadastrarAlimento(alimento: Alimentos){
        alimento.validarQtd()
        alimento.inserirNome()
        listaDeCompras.add(alimento)
    }

    private fun continuarLista(){
        try {
            println("--------------------------------------------------")
            println("Deseja incluir mais alimentos na lista?")
            println("[1] SIM")
            println("[2] NÃO")
            print("Digite o nº da opção escolhida: ")
            when(readln().toInt()){
                1 -> escolherTipoAlimento()
                2 -> exibirLista()
                else -> {
                    println("--------------------------------------------------")
                    println("               * Comando Inválido *               ")
                    continuarLista()
                }
            }
        }catch (ex: IllegalArgumentException){
            println("--------------------------------------------------")
            println("               * Comando Inválido *               ")
            continuarLista()
        }
    }

    private fun exibirLista(){
        println("--------------------------------------------------")
        println("LISTA DE COMPRAS: ")
        listaDeCompras.forEach {
            println("- ${it.nome}: ${it.quantidade}")
        }
        println("--------------------------------------------------")
        println("QUANTIDADE DE ALIMENTOS: ")
        println("- Qtd de verdura a ser comprada é: $qtdVerduras")
        println("- Qtd de legume a ser comprado é: $qtdLegumes")
        println("- Qtd de grão a ser comprado é: $qtdGraos")
        println("- Qtd de outro alimento a ser comprado é: $qtdOutros")

        exitProcess(0)
    }
}