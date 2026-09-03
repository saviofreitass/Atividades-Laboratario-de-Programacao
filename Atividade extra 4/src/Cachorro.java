public class Cachorro extends Animal {

    public Cachorro(String nome, int idade, String cor) {
        super(nome, idade, cor, "AU, AU!");
    }

    @Override
    public void emitirSom() {
        System.out.println("Latindo: " + getSom());
    }
}