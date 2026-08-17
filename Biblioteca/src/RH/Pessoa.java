package RH;


import Enum.Genero;

public class Pessoa {
    private String nome;
    private int idade;
    private String raca;
    private Genero genero;

    public Pessoa(String nome, int idade, String raca, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.genero = genero;
    }
}
