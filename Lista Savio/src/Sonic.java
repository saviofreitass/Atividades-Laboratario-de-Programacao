/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Sonic extends Heroi{
    private int velocidade;

    public Sonic(int velocidade, String nome, int vida, int energia) {
        super(nome, vida, energia);
        this.velocidade = velocidade;
    }
        
    @Override
    public void atacar() {
        System.out.println("Sonic atacando: Giraaaando");
    }
    
    
    
}
