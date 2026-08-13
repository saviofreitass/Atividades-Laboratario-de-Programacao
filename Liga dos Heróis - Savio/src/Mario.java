/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Mario extends Heroi{
    private int diasSemTirarBigode;

    public Mario(int diasSemTirarBigode, String nome, int vida, int energia) {
        super(nome, vida, energia);
        this.diasSemTirarBigode = diasSemTirarBigode;
    }

    @Override
    public void atacar() {
        System.out.println("Mario atacando: Pulando na sua cabeça");
    }
    
    
    
}
