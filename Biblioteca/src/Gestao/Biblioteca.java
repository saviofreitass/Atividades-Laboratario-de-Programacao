package Gestao;

import RH.Pessoa;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import Enum.Genero;

public class Biblioteca {

    Scanner scanner = new Scanner(System.in);

    public ArrayList<Livro> livros;
    public ArrayList<Pessoa> membros;
    public ArrayList<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.membros = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarLivro(Pessoa pessoa) {
        if(ehGerenteRh(pessoa)) {
            imprimeAlerta(pessoa.getTipo(), "adicionar livro");
            return;
        }

        int tipo = 0;
        while(true) {
            System.out.println("Qual tipo de livro você deseja adicionar? \n 1-Livro fisico \n 2-Ebook \n");
            try {
                tipo = scanner.nextInt();
                scanner.nextLine();
                if(tipo == 1 || tipo == 2) break;
                System.out.println("Opcao invalida");
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida");
                scanner.nextLine();
            }
        }

        Livro novo = pegaInfoLivros(tipo);
        if(novo != null) livros.add(novo);
    }

    public void removerLivro(Pessoa pessoa) {
        if(ehGerenteRh(pessoa)) {
            imprimeAlerta(pessoa.getTipo(), "remover livro");
            return;
        }
        if(!listarLivros()) return;
        System.out.println("Digite o titulo do livro para remover: ");
        String nome = scanner.nextLine();
        for(Livro livro : livros){
            if(livro.getTitulo().toLowerCase().contains(nome.toLowerCase())){
                livros.remove(livro);
                System.out.println("Livro removido com sucesso.");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public boolean listarLivros() {
        if(livros.isEmpty()){
            System.out.println("Não ha livros cadastrados");
            return false;
        }
        int i = 1;
        for (Livro livro : livros) {
            System.out.println( i + " - Nome do livro: " + livro.getTitulo());
            i++;
        }
        return true;
    }

    public void editarLivro(Pessoa pessoa){
        if(ehGerenteRh(pessoa)) {
            imprimeAlerta(pessoa.getTipo(), "editar livro");
            return;
        }
        if(!listarLivros()) return;

        try {
            System.out.println("Escolha o numero do livro que deseja editar: ");
            int opcao = scanner.nextInt();

            if (opcao < 1 || opcao > livros.size()) {
                System.out.println("Opcao invalida.");
                scanner.nextLine();
                return;
            }

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
                scanner.nextLine();
                livros.get(opcao-1).setNumeroPaginas(paginas);
            }else{
                System.out.println("Opcao invalida");
                return;
            }
            System.out.println("Livro alterado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida");
            scanner.nextLine();
        }
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

    public ArrayList<Livro> listarLivrosDisponiveis(){
        if(livros.isEmpty()){
            return null;
        }
        ArrayList<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if(livro.isDisponivel()) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public void adicionarMembro(Pessoa pessoa){
        if(!ehGerenteRh(pessoa)){
            imprimeAlerta(pessoa.getTipo(), "adicionar membro");
        }
        membros.add(pegaInfoMembro());
    }

    public void removerMembro(Pessoa pessoa){
        if(!ehGerenteRh(pessoa)) {
            imprimeAlerta(pessoa.getTipo(), "remover membro");
            return;
        }
        System.out.println("Digite o nome do membro para remover: ");
        String nome = scanner.nextLine();
        for( Pessoa membro : membros){
            if(membro.getNome().toLowerCase().contains(nome.toLowerCase())){
                membros.remove(membro);
                return;
            }
        }
    }

    public boolean listarMembro(){
        if(membros.isEmpty()){
            System.out.println("Não ha membros cadastrados");
            return false;
        }
        int i = 1;
        for (Pessoa membro : membros) {
            System.out.println( i + " - Nome do membro: " + membro.getNome());
            i++;
        }
        return true;
    }

    public void editarMembro(Pessoa pessoa){
        if(!ehGerenteRh(pessoa)) {
            imprimeAlerta(pessoa.getTipo(), "editar membro");
            return;
        }
        if(!listarMembro()) return;

        try {
            System.out.println("Escolha o numero do membro que deseja editar: ");
            int opcao = scanner.nextInt();

            if (opcao < 1 || opcao > membros.size()) {
                System.out.println("Opcao invalida");
                scanner.nextLine();
                return;
            }

            System.out.println("O que você deseja alterar? \n 1-Nome");
            int opcao2 = scanner.nextInt();
            scanner.nextLine();

            if(opcao2 == 1){
                System.out.println("Informe o nome: ");
                String nome = scanner.nextLine();
                membros.get(opcao-1).setNome(nome);
                System.out.println("Membro alterado com sucesso!");
            }else{
                System.out.println("Opcao invalida");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida");
            scanner.nextLine();
        }
    }

    public void realizarEmprestimo(){
        ArrayList<Livro> resultado = listarLivrosDisponiveis();
        if (resultado == null || resultado.isEmpty()) {
            System.out.println("Não ha livros disponiveis");
            return;
        }

        if(membros.isEmpty()){
            System.out.println("Não há membros para realizar emprestimo");
            return;
        }

        try {
            int j = 1;
            for (Pessoa membro : membros) {
                System.out.println( j + " - Nome do membro: " + membro.getNome());
                j++;
            }

            System.out.println("Digite o numero do membro que vai fazer o emprestimo:");
            int opcaoMembro = scanner.nextInt();
            scanner.nextLine();

            if(opcaoMembro < 1 || opcaoMembro > membros.size()){
                System.out.println("Opcao invalida");
                return;
            }

            Pessoa membroEmprestimo = membros.get(opcaoMembro-1);

            int i = 1;
            for (Livro livro : resultado) {
                System.out.println( i + " - Nome do livro: " + livro.getTitulo());
                i++;
            }

            System.out.println("Digite o numero do livro que vai ser emprestado:");
            int opcaoLivro = scanner.nextInt();
            scanner.nextLine();

            if(opcaoLivro < 1 || opcaoLivro > resultado.size()){
                System.out.println("Opcao invalida");
                return;
            }

            resultado.get(opcaoLivro-1).setDisponivel(false);
            emprestimos.add(new Emprestimo(membroEmprestimo, resultado.get(opcaoLivro-1)));
            System.out.println("Emprestimo realizado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida");
            scanner.nextLine();
        }
    }

    public void devolverEmprestimo(){
        if(emprestimos.isEmpty()){
            System.out.println("Não há emprestimos ativos");
            return;
        }

        try {
            int i = 1;
            for(Emprestimo emprestimo : emprestimos){
                System.out.println( i + "- Livro: " + emprestimo.getLivro().getTitulo() + ", Membro: " + emprestimo.getMembro().getNome());
                i++;
            }

            System.out.println("Escolha o numero do emprestimo para devolver: ");
            int opcaoEmprestimo = scanner.nextInt();
            scanner.nextLine();

            if(opcaoEmprestimo < 1 || opcaoEmprestimo > emprestimos.size()){
                System.out.println("Opcao invalida");
                return;
            }

            emprestimos.get(opcaoEmprestimo-1).getLivro().setDisponivel(true);
            emprestimos.get(opcaoEmprestimo-1).setDataDevolucao(new Date());

            System.out.println("Devolução concluida com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida");
            scanner.nextLine();
        }
    }

    public Livro pegaInfoLivros(int opc){
        System.out.println("Informe o nome do livro:");
        String titulo = scanner.nextLine();
        System.out.println("Informe o Autor:");
        String autor = scanner.nextLine();

        int paginas = 0;
        while(true) {
            try {
                System.out.println("Informe o numero de paginas:");
                paginas = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida");
                scanner.nextLine();
            }
        }

        Livro livroNovo = null;

        if(opc == 1){
            while(true) {
                try {
                    System.out.println("Informe o peso:");
                    int peso = scanner.nextInt();
                    scanner.nextLine();
                    livroNovo = new LivroFisico(peso, titulo, autor, paginas);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada invalida");
                    scanner.nextLine();
                }
            }
        }else if(opc == 2){
            while(true) {
                try {
                    System.out.println("Informe o tamanho do arquivo:");
                    int tamanhoArquivo = scanner.nextInt();
                    scanner.nextLine();
                    livroNovo = new Ebook(tamanhoArquivo, titulo, autor, paginas);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada invalida");
                    scanner.nextLine();
                }
            }
        }
        return livroNovo;
    }

    public boolean ehGerenteRh(Pessoa pessoa){
        return pessoa.getTipo().equals("GerenteRh");
    }

    public void imprimeAlerta(String tipoPessoa, String campo){
        System.out.println("Você está logado com um " + tipoPessoa + ", ele nao pode " + campo + "!");
    }

    public Pessoa pegaInfoMembro(){
        System.out.println("Informe o nome da pessoa");
        String nome = scanner.nextLine();
        String generoOpcao;
        do{
            System.out.println("Digite o genero da pessoa: (M para Masculino, F para Feminino)");
            generoOpcao = scanner.nextLine();
        }while(!generoOpcao.equalsIgnoreCase("M") && !generoOpcao.equalsIgnoreCase("F"));
        Genero genero;
        if(generoOpcao.equalsIgnoreCase("M")){
            genero = Genero.MASCULINO;
        }else{
            genero = Genero.FEMININO;
        }
        return new Pessoa(nome, genero, "Membro");
    }
}