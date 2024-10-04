package com.dudar.teste;

import java.util.List;
import java.util.LinkedList;

import org.springframework.stereotype.Repository;

@Repository
public class AcervoMemorial implements IAcervoRepository {
    private List<Livro> livros;

    public AcervoMemorial() {
        livros = new LinkedList<>();
        livros.add(new Livro(100, "Pokemon", "eu", 2020));
        livros.add(new Livro(120, "ZELDA the cao", "vc", 2024));
        livros.add(new Livro(140, "LOL", "ana maria paula de lourdes", 2016));
        livros.add(new Livro(140, "VAVAL", "mana de casa", 2010));
        livros.add(new Livro(500, "COMO SAIR DE CASA", "eu", 2021));
    }

    @Override
    public List<Livro> getAll() {
        return livros;
    }

    @Override
    public List<String> getTitulos() {
        return getAll()
                .stream()
                .map(livro -> livro.getTitulo())
                .toList();
    }

    @Override
    public List<String> getAutores() {
        return getAll()
                .stream()
                .map(livro -> livro.getAutor())
                .toList();
    }

    @Override
    public List<Livro> getLivrosDoAutor(String autor) {
        return getAll()
                .stream()
                .filter(livro -> livro.getAutor().equals(autor))
                .toList();
    }

    @Override
    public Livro getLivroTitulo(String titulo) {
        return getAll()
                .stream()
                .filter(livro -> livro.getTitulo().equals(titulo))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean cadastraLivroNovo(Livro livro) {
        livros.add(livro);
        return true;
    }

    @Override
    public boolean removeLivro(long codigo) {
        List<Livro> tmp = livros.stream()
                .filter(livro -> livro.getId() == codigo)
                .toList();
        return tmp.removeAll(tmp);
    }
}
