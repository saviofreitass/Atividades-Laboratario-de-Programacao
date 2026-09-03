import java.util.ArrayList;

public class Veterinario {
    private ArrayList<Animal> animais = new ArrayList<Animal>();

    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }

    public void levarAnimaisParaCarrocinha() {
        for (Animal animal : animais) {
            animal.emitirSom();
            System.out.println(animal.getNome() + " foi colocado na carrocinha!\n");
        }
    }
}