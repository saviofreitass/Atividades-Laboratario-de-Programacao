
package RH;

import Enum.Genero;

public class Bibliotecario extends Pessoa {
    private int anosDeCasa;

    public Bibliotecario(String nome, Genero genero, int anosDeCasa) {
        super(nome, genero, "Bibliotecario");
        this.anosDeCasa = anosDeCasa;
    }
}
