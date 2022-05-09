package compras

abstract class AlimentoUnidades: Alimentos {
    override var nome: String = ""
    override var quantidade: String = ""

    private var qtd = 0
    set(value) {
        if(value > 0){
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
            print("Digite a quantidade(un): ")
            qtd = readln().toInt()
            quantidade = "$qtd (un)"
        }catch (ex: NumberFormatException){
            println("----------------------------------------------------------------------------")
            println("* Para $tipoAlimento, a quantidade deve ser informada em unidades inteiras *")
            println("----------------------------------------------------------------------------")
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