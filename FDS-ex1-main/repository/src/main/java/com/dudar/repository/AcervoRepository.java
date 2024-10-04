package com.dudar.repository;

import java.util.List;

public interface AcervoRepository {
    List<Livro> getAll();
    List<String> getTitulos();
    List<String> getAutores();
    List<Livro> getLivrosDoAutor(String autor);
    Livro getLivroTitulo(String titulo);
    boolean cadastraLivroNovo(Livro livro);
    boolean removeLivro(long codigo);
    boolean retirarLivro(long id, long codigoUsuario);
    boolean devolverLivro(long id);
    List<Livro> listarLivrosNaoEmprestados();
    List<Livro> listarLivrosEmprestadosParaUsuario(long codigoUsuario);
}

