public class Coelho extends Animal {

    public Coelho(String nome, int idade, String cor) {
        super(nome, idade, cor, "Ronronando...");
    }

    @Override
    public void emitirSom() {
        System.out.println("Ronronando: " + getSom());
    }
}