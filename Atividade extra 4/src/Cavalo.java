public class Cavalo extends Animal {

    public Cavalo(String nome, int idade, String cor) {
        super(nome, idade, cor, "Relinchando...");
    }

    @Override
    public void emitirSom() {
        System.out.println("Relinchando: " + getSom());
    }
}