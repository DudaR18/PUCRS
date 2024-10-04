package dudar.com.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
public class Controller {
    private AcervoRepository livros;
    private UsuarioRepository usuarios;

    @Autowired
    public Controller(AcervoRepository livros, UsuarioRepository usuarios, JdbcTemplate jdbcTemplate) {
        this.livros = livros;
        this.usuarios = usuarios;
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/retira/{idLivro}/{codigoUsuario}")
    public boolean retiraLivro(@PathVariable long idLivro, @PathVariable long codigoUsuario) {
        Livro livro = livros.getLivroTitulo(idLivro);
        if (livro != null && livro.getCodigoUsuario() == -1) {
            String sql = "UPDATE Livros SET codigo_usuario = ? WHERE id = ?";
            return jdbcTemplate.update(sql, codigoUsuario, idLivro) > 0;
        }
        return false;
    }

    @PostMapping("/devolve/{idLivro}")
    public boolean devolveLivro(@PathVariable long idLivro) {
        Livro livro = livros.getLivroTitulo(idLivro);
        if (livro != null && livro.getCodigoUsuario() != -1) {
            String sql = "UPDATE Livros SET codigo_usuario = -1 WHERE id = ?";
            return jdbcTemplate.update(sql, idLivro) > 0;
        }
        return false;
    }

    private Livro mapRowToLivro(ResultSet rs, int rowNum) throws SQLException {
        return new Livro(
                rs.getLong("id"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getInt("ano"),
                rs.getLong("codigo_usuario"));
    }
    
    @GetMapping("/livrosNaoEmprestados")
    public List<Livro> livrosNaoEmprestados() {
        String sql = "SELECT * FROM Livros WHERE codigo_usuario = -1";
        return jdbcTemplate.query(sql, this::mapRowToLivro);
    }

    @GetMapping("/livrosEmprestados/{codigoUsuario}")
    public List<Livro> livrosEmprestadosPorUsuario(@PathVariable long codigoUsuario) {
        String sql = "SELECT * FROM Livros WHERE codigo_usuario = ?";
        return jdbcTemplate.query(sql, this::mapRowToLivro, codigoUsuario);
    }
}
