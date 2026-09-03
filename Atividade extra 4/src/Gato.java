public class Gato extends Animal {

    public Gato(String nome, int idade, String cor) {
        super(nome, idade, cor, "MIAU!");
    }

    @Override
    public void emitirSom() {
        System.out.println("Miando: " + getSom());
    }
}