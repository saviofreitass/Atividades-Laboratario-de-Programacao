/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Aluno
 */
public class Principal {

    public static void main(String[] args) {
        Batman batman = new Batman("Batman", 100, 50, 100, "Rua dos bobos, numero 0", 999999999);
        Heroi superman = new Heroi("SuperMan", 100, 100, 100);

        batman.apresentar();
        superman.apresentar();

        batman.visualizarSaldo();

    }
}
