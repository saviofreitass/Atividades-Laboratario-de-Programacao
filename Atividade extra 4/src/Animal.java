public abstract class Animal {
    private String nome;
    private int idade;
    private String cor;
    private String som;

    public abstract void emitirSom();

    public Animal(String nome, int idade, String cor, String som) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
        this.som = som;
    }

    public String getSom() {
        return som;
    }

    public String getNome() {
        return nome;
    }

    public void setSom(String som) {
        this.som = som;
    }
}