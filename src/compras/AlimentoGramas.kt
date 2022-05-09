package compras

abstract class AlimentoGramas: Alimentos {
    override var nome: String = ""
    override var quantidade: String = ""

    private var qtd = 0.0
        set(value) {
            if(value > 0.0){
                field = value
            }
            else{
                println("--------------------------------------------------")
                println("    * Não é possível inserir números negativos *   ")
                println("--------------------------------------------------")
                validarQtd()
            }
        }

    override fun validarQtd() {
        try {
            print("Digite a quantidade(g): ")
            qtd = readln().toDouble()
            val qtdKg = qtd/1000
            quantidade = "$qtdKg (kg)"
        }
        catch (ex: NumberFormatException){
            println("---------------------------------------------------------------------")
            println("* Para $tipoAlimento, a quantidade deve ser informada com ponto (.) *")
            println("---------------------------------------------------------------------")
            validarQtd()
        }
        catch (ex: UnsupportedOperationException){
            println("--------------------------------------------------")
            println("      * Não é permitido inserir valor vazio *     ")
            println("--------------------------------------------------")
            validarQtd()
        }
    }

}