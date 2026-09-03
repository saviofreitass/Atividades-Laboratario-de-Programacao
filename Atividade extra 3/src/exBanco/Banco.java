package exBanco;

public class Banco {
    private int numero;
    private int agenciaNumero;
    private String agenciaNome;
    private int tipo;
    private double saldo;


    public Banco(int numero, int agenciaNumero, String agenciaNome, int tipo, double saldo) {
        this.numero = numero;
        this.agenciaNumero = agenciaNumero;
        this.agenciaNome = agenciaNome;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public Banco(int numero, int agenciaNumero, String agenciaNome, int tipo) {
        this(numero, agenciaNumero, agenciaNome, tipo, 0);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getTipo() {
        return tipo;
    }

    public int getNumero() {
        return numero;
    }

    public double creditarConta(double saldoCreditado){
        if(getTipo() == 4){
            System.out.println("\nOps! parece que essa conta foi encerrada!");
            return getSaldo();
        }

        this.saldo = getSaldo() + saldoCreditado;
        return getSaldo();
    }

    public double debitarSaldo(double saldoDebitado){
        if(getTipo() == 4){
            System.out.println("\nOps! parece que essa conta foi encerrada!");
            return getSaldo();
        }

        this.saldo = getSaldo() - saldoDebitado;
        return getSaldo();
    }

    public double encerrarConta(){
        if(getSaldo() < 0){
            System.out.println("\nSua conta nao pode ser encerrada porque o saldo e negativo! Regularize seu saldo antes de encerrar a conta");
            return getSaldo();
        }

        this.tipo = 4;
        double saldoEncerrado = getSaldo();
        setSaldo(0);

        return saldoEncerrado;
    }

    public void textoEncerrar(double saldoEncerrado){
        System.out.println("A conta " + getNumero() + " com o tipo " + getTipo() + " foi encerrada com o saldo R$ " + saldoEncerrado);
    }
}