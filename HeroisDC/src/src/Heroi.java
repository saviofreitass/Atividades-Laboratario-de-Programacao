/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Aluno
 */
public abstract class Heroi {

    private String nome;
    private int vida;
    private int energia;
    private int velocidade;

    public Heroi(String nome, int vida, int energia, int velocidade) {
        this.nome = nome;
        this.vida = vida;
        this.energia = energia;
        this.velocidade = velocidade;
    }

    public void apresentar() {
        System.out.println("Eu sou o " + this.nome + "!");
    }
    
    public abstract void atacar();

}
