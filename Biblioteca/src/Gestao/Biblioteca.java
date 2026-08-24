package Gestao;

import RH.Pessoa;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    Scanner scanner = new Scanner(System.in);

    public ArrayList<Livro> livros;
    public ArrayList<Pessoa> membros;
    public ArrayList<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.membros = new ArrayList<>();
    }

    //-----------------------------------------/Métodos Livro/--------------------------------------------------------//
    public void adicionarLivro() {
        System.out.println("Qual tipo de livro você deseja adicionar? \n 1-Livro fisico \n 2-Ebook \n");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        livros.add(pegaInfoLivros(tipo));
    }
    
    public void removerLivro(){
        System.out.println("Digite o nome do livro para remover: ");
        String nome = scanner.nextLine();
        for( Livro livro : livros){
            if(livro.getTitulo().toLowerCase().contains(nome.toLowerCase())){
                livros.remove(livro);
                return;
            }
        }
    }

    public void listarLivros() {
        if(livros.isEmpty()){
            System.out.println("Não ha livros cadastrados");
            return;
        }
        int i = 1;
        for (Livro livro : livros) {
            System.out.println( i + " - Nome do livro: " + livro.getTitulo());
            i++;
        }
    }

    public void editarLivro(){
        listarLivros();
        System.out.println("Escolha o numero do livro que deseja editar: ");
        int opcao = scanner.nextInt();
        System.out.println("O que você deseja alterar? \n 1-Titulo \n 2-Autor \n 3-Numero de paginas \n");
        int opcao2 = scanner.nextInt();
        scanner.nextLine();

        if(opcao2 == 1){
            System.out.println("Informe o titulo: ");
            String titulo = scanner.nextLine();
            livros.get(opcao-1).setTitulo(titulo);
        }else if(opcao2 == 2){
            System.out.println("Informe o Autor: ");
            String autor = scanner.nextLine();
            livros.get(opcao-1).setAutor(autor);
        }else if(opcao2 == 3){
            System.out.println("Informe o numero de paginas: ");
            int paginas = scanner.nextInt();
            livros.get(opcao-1).setNumeroPaginas(paginas);
        }else{
            System.out.println("Opcao invalida");
            return;
        }
        System.out.println("Livro alterado com sucesso!");

    }

    public ArrayList<Livro> buscarLivroPorTitulo() {
        if(livros.isEmpty()){
            System.out.println("Não ha livros cadastrados");
            return null;
        }
        System.out.println("Digite o nome do livro para buscar: ");
        String titulo = scanner.nextLine();
        ArrayList<Livro> resultados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(livro);
            }
        }

        System.out.println("Livros encontrados: ");

        int i=1;
        for(Livro livro: resultados){
            System.out.println( i + " - Nome do livro: " + livro.getTitulo());
            i++;
        }
        return resultados;
    }
    //------------------------------------------/Fim métodos Livro/------------------------------------------------------//


    //----------------------------------------------//----------------------------------------------------//
    //Funcoes auxiliares
    public Livro pegaInfoLivros(int opc){
        System.out.println("Informe o nome do livro:");
        String titulo = scanner.nextLine();
        System.out.println("Informe o Autor:");
        String autor = scanner.nextLine();
        System.out.println("Informe o numero de paginas:");
        int paginas = scanner.nextInt();
        scanner.nextLine();

        Livro livroNovo;

        if(opc == 1){
            System.out.println("Informe o peso:");
            int peso = scanner.nextInt();
            scanner.nextLine();
            livroNovo = new LivroFisico(peso, titulo, autor, paginas);
        }else if(opc == 2){
            System.out.println("Informe o tamanho do arquivo:");
            int tamanhoArquivo = scanner.nextInt();
            scanner.nextLine();
            livroNovo = new Ebook(tamanhoArquivo, titulo, autor, paginas);
        }else{
            System.out.println("Opcao invalida");
            return null;
        }
        return livroNovo;

    }
}
