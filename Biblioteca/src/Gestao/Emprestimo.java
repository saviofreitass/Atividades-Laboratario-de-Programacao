package Gestao;

import RH.Pessoa;

import java.util.Date;

public class Emprestimo {
    private Pessoa membro;
    private Livro livro;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(Pessoa membro, Livro livro) {
        this.membro = membro;
        this.dataEmprestimo = new Date();
        this.livro = livro;
    }

    public Pessoa getMembro() {
        return membro;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
