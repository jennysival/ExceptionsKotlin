package calculo

class CalculoMatematico {

    fun divisao(num1: Int, num2: Int): Int{

        try {
            val dividir = num1/num2
        }catch (ex: ArithmeticException){
            println("A operação não pode ser realizada")
        }
        return 0
    }

}