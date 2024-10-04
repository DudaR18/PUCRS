package dudar.com.repository;

import java.util.List;

public interface AcervoRepository {
        List<Livro> getAll();

        List<String> getTitulos();

        List<String> getAutores();

        List<Livro> getLivrosDoAutor(String autor);

        Livro getLivroTitulo(long titulo);

        boolean cadastraLivroNovo(Livro livro);

        boolean removeLivro(long codigo);
}
