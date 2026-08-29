package RH;

import Enum.Genero;

public class Pessoa {
    private String nome;
    private Genero genero;
    private String tipo;

    public Pessoa(String nome, Genero genero, String tipo) {
        this.nome = nome;
        this.genero = genero;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
