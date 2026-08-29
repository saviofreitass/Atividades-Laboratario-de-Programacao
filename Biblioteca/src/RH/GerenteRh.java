package RH;

import Enum.Genero;

public class GerenteRh extends Pessoa{
    private double salario;

    public GerenteRh(String nome, Genero genero, double salario) {
        super(nome, genero, "GerenteRh");
        this.salario = salario;
    }
}
