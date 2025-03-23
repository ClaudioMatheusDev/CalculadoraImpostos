package calculadora.Loja;


import java.util.ArrayList;
import java.util.List;

import calculadora.Calculadora.CalculadoraImposto;

public class Loja {
    private Cliente cliente;
    private List<Produto> produtos;
    private CalculadoraImposto calculadora;

    public Loja() {
        this.produtos = new ArrayList<>();
        this.calculadora = new CalculadoraImposto();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public double calcularTotalVenda() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.calcularValorFinal(calculadora);
        }
        return total;
    }

    public void finalizarVenda() {
        if (cliente == null || produtos.isEmpty()) {
            System.out.println("Erro: Cliente ou produtos não definidos.");
            return;
        }

        double total = calcularTotalVenda();
        System.out.println("=======================================");
        System.out.println("           NOTA FISCAL");
        System.out.println("=======================================");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("---------------------------------------");
        System.out.println("Produtos:");

        for (Produto produto : produtos) {
            System.out.println("- " + produto.getNome() + ": R$ " + String.format("%.2f", produto.calcularValorFinal(calculadora)));
        }

        System.out.println("---------------------------------------");
        System.out.println("Total da venda: R$ " + String.format("%.2f", total));
        System.out.println("=======================================");
    }
}