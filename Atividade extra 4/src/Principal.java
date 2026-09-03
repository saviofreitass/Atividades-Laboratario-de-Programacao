public class Principal {
    public static void main(String[] args) {
        Veterinario veterinario = new Veterinario();

        Cachorro cachorra = new Cachorro("Mel", 7, "Caramelo");
        Cavalo cavalo = new Cavalo("Princesa", 15, "Marrom");
        Gato gato = new Gato("Chimbica", 6, "Malhada");
        Coelho coelho = new Coelho("Çenora", 6, "Preto");

        veterinario.adicionarAnimal(cachorra);
        veterinario.adicionarAnimal(cavalo);
        veterinario.adicionarAnimal(gato);
        veterinario.adicionarAnimal(coelho);

        veterinario.levarAnimaisParaCarrocinha();

        cachorra.emitirSom();
        System.out.println("Modifica som do cachorro");
        cachorra.setSom("AUUUUUUUUUUUUUUUU!");
        cachorra.emitirSom();
    }
}