/* package dudar.com.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AcervoMemoria implements AcervoRepository {
    private List<Livro> livros;

    public AcervoMemoria() {
        livros = new LinkedList<>();
        livros.add(new Livro(45, "Como zerar Zelda em 10 minutos", "EnzinhoGameplay", 2022, 1151));
        livros.add(new Livro(200, "Guia definitivo para Stardew Valley", "Duda", 2020, 1152));
        livros.add(new Livro(15, "Principios da vida", "Luizinho", 2023, 1153));
        livros.add(new Livro(200, "Livro de receitas", "Maethe", 2019, 1154));
    }

    @Override
    public List<Livro> getAll() {
        return livros;
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
    public Livro getLivroTitulo(long titulo) {
        return getAll()
                .stream()
                .filter(livro -> livro.getTitulo().equals(titulo))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<String> getTitulos() {
        return getAll()
                .stream()
                .map(livro -> livro.getTitulo())
                .toList();
    }
}
 */