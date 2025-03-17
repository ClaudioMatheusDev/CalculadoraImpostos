package calculadora;

import calculadora.fiscal.Calculadora;

public class CalculadoraImposto extends Calculadora{

    public double calcularImposto(double valorProduto) {
        if (valorProduto <= 50.00) {
            return multiplicar(valorProduto, 0.20);
        } else{
            return subtrair(multiplicar(valorProduto, 0.60), 20);
        }
    }
}


