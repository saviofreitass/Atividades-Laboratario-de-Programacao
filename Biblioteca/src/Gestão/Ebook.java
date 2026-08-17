package Gestão;

public class Ebook extends Livro {

    private double tamanhoArquivo;

    public Ebook(double tamanhoArquivo, String titulo, String autor, int numeroPaginas) {
        super(titulo, autor, numeroPaginas);
        this.tamanhoArquivo = tamanhoArquivo;
    }

    @Override
    public void descricao() {
        System.out.println("Descrição ebook");
    }

}
