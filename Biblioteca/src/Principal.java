
import Gestão.LivroFisico;
import Gestão.Livro;
import Gestão.Ebook;
import Gestão.Biblioteca;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        Biblioteca bibliotecaUni = new Biblioteca();
        Ebook ebook1 = new Ebook(100, "Como Emagrecer em 30 dias", "Eduardo Feliciano", 30);
        LivroFisico livroFisico1 = new LivroFisico(5, "Como vender ebooks", "Eduardo Feliciano", 20);

        bibliotecaUni.adicionarLivro(ebook1);
        bibliotecaUni.adicionarLivro(livroFisico1);

        bibliotecaUni.listarLivros();
        
        ArrayList<Livro> resultadoBusca = bibliotecaUni.buscarLivroPorTitulo("emagrecer");

        if(resultadoBusca.isEmpty()){
            System.out.println("Nenhum livro encotrado com esse título");
        }else{
            System.out.println("Livros encontrados: " + resultadoBusca.size());
            for(Livro livro: resultadoBusca){
                System.out.println(livro.getTitulo());
            }
            System.out.println("------------------//-------------------");
        }
    }
}
