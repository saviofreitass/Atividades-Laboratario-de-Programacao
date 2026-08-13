/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Principal {

    public static void main(String[] args) {
        Goku goku = new Goku(100, "Goku", 100, 100);
        Sonic sonic = new Sonic(100, "Sonic", 50, 80);
        Mario mario = new Mario(10, "Mario", 20, 80);
        
        goku.apresentar();
        sonic.apresentar();
        mario.apresentar();
        
        goku.atacar();
        sonic.atacar();
        mario.atacar();

    }
}
