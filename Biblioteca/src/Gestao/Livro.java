package Gestao;

public abstract class Livro {

    private String titulo;
    private String autor;
    private int numeroPaginas;
    private boolean isDisponivel;

    public Livro(String titulo, String autor, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.isDisponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDisponivel(boolean disponivel) {
        this.isDisponivel = disponivel;
    }

    public boolean isDisponivel() {
        return this.isDisponivel;
    }

    public abstract void descricao();
}
