package calculadora.fiscal;

import java.util.Scanner;

import calculadora.Calculadora.Calculadora;
import calculadora.Calculadora.CalculadoraImposto;
import calculadora.Loja.Cliente;
import calculadora.Loja.Loja;
import calculadora.Loja.Produto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();
        CalculadoraImposto calculadoraImposto = new CalculadoraImposto();
        Loja loja = new Loja();

        while (true) {
            System.out.println("=======================================");
            System.out.println("       SISTEMA DE LOJA E IMPOSTOS");
            System.out.println("=======================================");
            System.out.println("1. Operações básicas (somar, subtrair, etc.).");
            System.out.println("2. Calcular imposto de importação.");
            System.out.println("3. Registrar venda na loja.");
            System.out.println("0. Fechar Programa.");
            System.out.println("======================================");

            int opcao = lerNumeroInt("Digite a opção desejada: ", scanner);

            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }

            switch (opcao) {
                case 1:

                    System.out.println("=======================================");
                    System.out.println("       OPERAÇÕES BÁSICAS");
                    System.out.println("=======================================");
                    System.out.println("1. Somar.");
                    System.out.println("2. Multiplicar.");
                    System.out.println("3. Dividir.");
                    System.out.println("4. Subtrair.");
                    System.out.println("======================================");

                    int opcaoCalculadora = lerNumeroInt("Digite a opção desejada: ", scanner);
                    double num1 = lerNumero("Digite o primeiro número: ", scanner);
                    double num2 = lerNumero("Digite o segundo número: ", scanner);

                    switch (opcaoCalculadora) {
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
                        default:
                            System.out.println("Opção inválida! Tente novamente.");
                            break;
                    }
                    break;

                case 2:

                    double valorProduto = lerNumero("Digite o valor do produto: ", scanner);
                    System.out.println("O imposto de importação é: " + calculadoraImposto.calcularImposto(valorProduto));
                    System.out.println("O valor final do produto é: " + calculadoraImposto.calcularValorFinal(valorProduto));
                    break;

                case 3:

                    System.out.println("=======================================");
                    System.out.println("       REGISTRAR VENDA NA LOJA");
                    System.out.println("=======================================");

                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nomeCliente, cpfCliente);
                    loja.setCliente(cliente);

                    while (true) {
                        System.out.println("---------------------------------------");
                        System.out.print("Digite o nome do produto (ou 'sair' para finalizar): ");
                        String nomeProduto = scanner.nextLine();
                        if (nomeProduto.equalsIgnoreCase("sair")) {
                            break;
                        }

                        double precoProduto = lerNumero("Digite o preço do produto: ", scanner);
                        System.out.print("O produto é importado? (s/n): ");
                        boolean isImportado = scanner.nextLine().equalsIgnoreCase("s");

                        Produto produto = new Produto(nomeProduto, precoProduto, isImportado);
                        loja.adicionarProduto(produto);
                    }

                    loja.finalizarVenda();
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