package Gestao;
import java.util.Scanner;

public class LivroFisico extends Livro {

    Scanner scanner = new Scanner(System.in);
    private double peso;

    public LivroFisico(int peso, String titulo, String autor, int numeroPaginas) {
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
