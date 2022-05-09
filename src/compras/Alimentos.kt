package compras

interface Alimentos {
    var tipoAlimento: String
    var nome: String
    var quantidade: String

    fun validarQtd()

    fun inserirNome(){

        try {
            print("Digite o nome de $tipoAlimento: ")
            nome = readln()
            if(nome == ""){
                println("--------------------------------------------------")
                println("      * Não é permitido inserir nome vazio *      ")
                println("--------------------------------------------------")
                inserirNome()
            }
            else{
                nome = nome
            }
        }catch (ex: UnsupportedOperationException){
            println("--------------------------------------------------")
            println("      * Não é permitido inserir nome vazio *      ")
            println("--------------------------------------------------")
            inserirNome()
        }
    }
}