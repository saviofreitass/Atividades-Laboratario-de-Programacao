import Gestao.Biblioteca;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Enum.Genero;
import RH.Bibliotecario;
import RH.GerenteRh;
import RH.Pessoa;

public class Principal {

    public static void main(String[] args) {
        ArrayList<Pessoa> listaDeUsuarios = new ArrayList<>();
        Pessoa usuarioLogado;
        Biblioteca bibliotecaUni = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        boolean cadastrar = true;

        do {
            listaDeUsuarios.add(cadastrarUsuario());
            System.out.println("Deseja cadastrar um novo usuario? \n 1-Sim  2-Não");
            try {
                int escolha = scanner.nextInt();
                if (escolha == 2) {
                    cadastrar = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Digite apenas números");
            } finally {
                scanner.nextLine();
            }
        } while (cadastrar);

        usuarioLogado = escolherUsuariosLogin(listaDeUsuarios);

        while (opcao != 12) {
            System.out.println("Pressione ENTER para continuar");
            scanner.nextLine();

            System.out.println("Escolha uma opção: \n 1-Adicionar Livro \n 2-Listar Livros \n 3-Remover Livro \n" +
                    " 4-Buscar livro \n 5-Editar Livro \n 6-Adicionar Membro \n 7-Listar Membros \n 8-Remover Membro \n 9-Editar Membro " +
                    "\n 10-Realizar Emprestimo \n 11-Devolver Emprestimo \n 12-Sair");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        bibliotecaUni.adicionarLivro(usuarioLogado);
                        break;
                    case 2:
                        bibliotecaUni.listarLivros();
                        break;
                    case 3:
                        bibliotecaUni.removerLivro(usuarioLogado);
                        break;
                    case 4:
                        bibliotecaUni.buscarLivroPorTitulo();
                        break;
                    case 5:
                        bibliotecaUni.editarLivro(usuarioLogado);
                        break;
                    case 6:
                        bibliotecaUni.adicionarMembro(usuarioLogado);
                        break;
                    case 7:
                        bibliotecaUni.listarMembro();
                        break;
                    case 8:
                        bibliotecaUni.removerMembro(usuarioLogado);
                        break;
                    case 9:
                        bibliotecaUni.editarMembro(usuarioLogado);
                        break;
                    case 10:
                        bibliotecaUni.realizarEmprestimo();
                        break;
                    case 11:
                        bibliotecaUni.devolverEmprestimo();
                        break;
                    case 12:
                        System.out.println("Bye bye!");
                        break;
                    default:
                        System.out.println("Opção invalida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Você deve digitar um número das opções.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    public static Pessoa cadastrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Para iniciar é necessário criar um usuário.");
        int opcao = 0;
        boolean opcaoValida = false;

        do {
            System.out.println("Escolha o tipo de usuario que deseja criar: \n 1-Gerente de Rh \n 2-Bibliotecario");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                if (opcao == 1 || opcao == 2) {
                    opcaoValida = true;
                } else {
                    System.out.println("Opção inválida! Digite 1 ou 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Você deve digitar um número válido.");
                scanner.nextLine();
            }
        } while (!opcaoValida);

        System.out.println("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();
        String generoOpcao;

        do {
            System.out.println("Digite o genero da pessoa: (M para Masculino, F para Feminino)");
            generoOpcao = scanner.nextLine();
        } while (!generoOpcao.equalsIgnoreCase("M") && !generoOpcao.equalsIgnoreCase("F"));

        Genero genero = generoOpcao.equalsIgnoreCase("M") ? Genero.MASCULINO : Genero.FEMININO;

        if (opcao == 1) {
            double salario = 0;
            boolean salarioValido = false;
            while (!salarioValido) {
                System.out.println("Digite o salario do Gerente: ");
                try {
                    salario = scanner.nextDouble();
                    salarioValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Salario invalido, digite apenas numeros.");
                    scanner.nextLine();
                }
            }
            return new GerenteRh(nome, genero, salario);
        } else {
            int tempoCasa = 0;
            boolean tempoValido = false;
            while (!tempoValido) {
                System.out.println("Digite o tempo de casa do Bibliotecario em anos: ");
                try {
                    tempoCasa = scanner.nextInt();
                    tempoValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Erro: O tempo de casa deve ser um número inteiro.");
                    scanner.nextLine();
                }
            }
            return new Bibliotecario(nome, genero, tempoCasa);
        }
    }

    public static Pessoa escolherUsuariosLogin(ArrayList<Pessoa> listaDeUsuarios) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (true) {
            int i = 1;
            System.out.println("Com qual usuário você deseja logar?");
            for (Pessoa pessoa : listaDeUsuarios) {
                System.out.println(i + " - Nome do usuario: " + pessoa.getNome());
                i++;
            }

            try {
                opcao = scanner.nextInt();
                return listaDeUsuarios.get(opcao - 1);
            } catch (InputMismatchException e) {
                System.out.println("Erro: Você deve digitar um número.");
                scanner.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Erro: Opção inválida, escolha um número correspondente a um usuário da lista.");
            }
        }
    }
}