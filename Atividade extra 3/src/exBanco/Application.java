package exBanco;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            Banco banco = new Banco(1, 100, "Sede", 1);
            int opcao = 0;
            while (opcao != 4 && opcao != 5) {
                System.out.println(" Escolha uma opção \n1 - Creditar Conta \n2 - Debitar Conta \n3 - Consultar Saldo \n4 - Encerrar Conta\n5 - Sair");

                try {
                    opcao = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Erro: digite apenas numeros inteiros!");
                    scanner.next();
                    opcao = 0;
                    continue;
                }

                switch (opcao) {
                    case 1:
                        if (banco.getTipo() == 4) {
                            System.out.println("Erro:Conta encerrada, não é possivel creditar!");
                            break;
                        }

                        System.out.println("Digite o valor que voce deseja creditar: ");
                        try {
                            double saldoACreditar = scanner.nextDouble();

                            if (saldoACreditar <= 0) {
                                System.out.println("Erro: Não é possível inserir um valor negativo!");
                                break;
                            }

                            banco.creditarConta(saldoACreditar);
                            System.out.println("Novo saldo: R$ " + banco.getSaldo());
                        } catch (InputMismatchException e) {
                            System.out.println("Erro: valor invalido! Digite apenas numeros.");
                            scanner.next();
                        }
                        break;
                    case 2:
                        if (banco.getTipo() == 4) {
                            System.out.println("Erro:Conta encerrada, não é possivel creditar!");
                            break;
                        }

                        System.out.println("Digite o valor que voce deseja debitar: ");
                        try {
                            double saldoDebitado = scanner.nextDouble();

                            if (saldoDebitado <= 0) {
                                System.out.println("Erro: o valor debitado precisa ser maior que zero!");
                                break;
                            }

                            banco.debitarSaldo(saldoDebitado);
                            System.out.println("Novo saldo: R$ " + banco.getSaldo());
                        } catch (InputMismatchException e) {
                            System.out.println("Erro: valor invalido! Digite apenas numeros.");
                            scanner.next();
                        }
                        break;
                    case 3:
                        System.out.println("O saldo atual da conta e: R$ " + banco.getSaldo());
                        break;
                    case 4:
                        if (banco.getSaldo() < 0) {
                            System.out.println("Erro: nao e possivel encerrar uma conta com saldo negativo! Regularize o saldo primeiro.");
                            opcao = 0;
                            break;
                        }

                        double saldoEncerrado = banco.encerrarConta();
                        banco.textoEncerrar(saldoEncerrado);
                        break;
                    case 5:
                        System.out.println("Saindo do sistema... Ate logo!");
                        break;
                    default:
                        System.out.println("Opcao invalida! Escolha um numero entre 1 e 5.");
                        break;
                }
            }


        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}