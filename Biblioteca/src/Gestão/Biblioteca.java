package Gestão;

import RH.Pessoa;
import java.util.ArrayList;

public class Biblioteca {

    public ArrayList<Livro> livros;
    public ArrayList<Pessoa> membros;
    public ArrayList<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.membros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }
    
    public void removerLivro(String titulo){
        ArrayList<Livro> resultadoBusca = buscarLivroPorTitulo(titulo);
        
        if(resultadoBusca.isEmpty()){
            System.out.println("Nenhum livro encotrado com esse título");
        }else{
            System.out.println("Livros encontrados: " + resultadoBusca.size());
            for(Livro livro: resultadoBusca){
                System.out.println(livro.getTitulo());
            }
            System.out.println("Escolha");
        }
        
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println("Nome do livro: " + livro.getTitulo());
        }
    }

    public ArrayList<Livro> buscarLivroPorTitulo(String titulo) {
        ArrayList<Livro> resultados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(livro);
            }
        }
        return resultados;
    }
    

}
