package Gestão;


import Gestão.Livro;

public class LivroFisico extends Livro {

    private double peso;

    public LivroFisico(double peso, String titulo, String autor, int numeroPaginas) {
        super(titulo, autor, numeroPaginas);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public void descricao() {
        System.out.println("Descrição livro físico...");
    }

}
