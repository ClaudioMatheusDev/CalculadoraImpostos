package calculadora.fiscal;

import java.util.Scanner;

import calculadora.CalculadoraImposto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();
        CalculadoraImposto calculadoraImposto = new CalculadoraImposto();

        while (true) {
            System.out.println("=======================================");
            System.out.println("       CALCULADORA DE IMPOSTOS");
            System.out.println("=======================================");
            System.out.println("1. Somar.");
            System.out.println("2. Multiplicar.");
            System.out.println("3. Dividir.");
            System.out.println("4. Subtrair.");
            System.out.println("5. Calcular imposto de importação.");
            System.out.println("0. Fechar Programa.");
            System.out.println("======================================");

            int opcao = lerNumeroInt("Digite a opção desejada: ", scanner);

            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }

            double num1 = 0, num2 = 0;

            if (opcao >= 1 && opcao <= 4) {
                num1 = lerNumero("Digite o primeiro número: ", scanner);
                num2 = lerNumero("Digite o segundo número: ", scanner);
            } else if (opcao == 5) {
                num1 = lerNumero("Digite o valor do produto: ", scanner);
            }

            switch (opcao) {
                case 1:
                    System.out.println("Resultado da soma: " + calculadora.somar(num1, num2));
                    break;
                case 2:
                    System.out.println("Resultado da multiplicação: " + calculadora.multiplicar(num1, num2));
                    break;
                case 3:
                    System.out.println("Resultado da divisão: " + calculadora.dividir(num1, num2));
                    break;
                case 4:
                    System.out.println("Resultado da subtração: " + calculadora.subtrair(num1, num2));
                    break;
                case 5:
                    System.out.println("O imposto de importação é: " + calculadoraImposto.calcularImposto(num1));
                    System.out.println("O valor final do produto é: " + calculadoraImposto.calcularValorFinal(num1));
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }

    private static double lerNumero(String mensagem, Scanner scanner) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(scanner.nextLine().replace(",", ".")); 
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
            }
        }
    }

    private static int lerNumeroInt(String mensagem, Scanner scanner) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido!");
            }
        }
    }
}
