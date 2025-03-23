package calculadora;

public class Produto {
    private String nome;
    private double preco;
    private boolean isImportado;

    public Produto(String nome, double preco, boolean isImportado) {
        this.nome = nome;
        this.preco = preco;
        this.isImportado = isImportado;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isImportado() {
        return isImportado;
    }

    public double calcularValorFinal(CalculadoraImposto calculadora) {
        if (isImportado) {
            return calculadora.calcularValorFinal(preco);
        } else {
            return preco * 1.23;
        }
    }
}