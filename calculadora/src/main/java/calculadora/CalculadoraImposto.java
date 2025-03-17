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

    public double calcularValorFinal(double precoProduto) {
        double imposto = calcularImposto(precoProduto);
        if (imposto >= 0) {
            return somar(precoProduto, imposto);
        } else {
            return -1; 
        }
    }

}


