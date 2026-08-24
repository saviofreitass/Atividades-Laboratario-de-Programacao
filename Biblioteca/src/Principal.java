
import Gestão.LivroFisico;
import Gestão.Livro;
import Gestão.Ebook;
import Gestão.Biblioteca;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Biblioteca bibliotecaUni = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao=0;

        while(opcao != 9){
            System.out.println("Escolha uma opção: \n 1-Adicionar Livro \n 2-Listar Livros \n 3-Remover Livro \n" +
                    " 4-Buscar livro \n 5-Editar Livro \n 9-Sair" );
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    bibliotecaUni.adicionarLivro();
                    scanner.nextLine();
                    break;
                case 2:
                    bibliotecaUni.listarLivros();
                    scanner.nextLine();
                    break;
                case 3:
                    bibliotecaUni.removerLivro();
                    scanner.nextLine();
                    break;
                case 4:
                    bibliotecaUni.buscarLivroPorTitulo();
                    scanner.nextLine();
                    break;
                case 5:
                    bibliotecaUni.editarLivro();
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Opçao invalida");
                    break;
            }
        }

    }
}

