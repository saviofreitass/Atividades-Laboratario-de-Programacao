/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Aluno
 */
public class Batman extends Heroi {

    private String enderecoMansao;
    private int saldoBancario;

    public Batman(String nome, int vida, int energia, int velocidade, String enderecoMansao, int saldoBancario) {
        super(nome, vida, energia, velocidade);
        this.enderecoMansao = enderecoMansao;
        this.saldoBancario = saldoBancario;
    }

    public void visualizarSaldo() {
        System.out.println("O saldo da conta eh: R$" + this.saldoBancario);
    }
    
    @Override
    public void atacar(){
        System.out.println("Jogando batarangues");
    }
}
