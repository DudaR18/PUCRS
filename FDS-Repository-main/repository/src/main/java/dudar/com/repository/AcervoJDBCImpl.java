package dudar.com.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AcervoJDBCImpl implements AcervoRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AcervoJDBCImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Livro mapRowToLivro(ResultSet rs, int rowNum) throws SQLException {
        return new Livro(
                rs.getLong("id"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getInt("ano"),
                rs.getLong("codigo_usuario"));
    }

    @Override
    public List<Livro> getAll() {
        String sql = "SELECT * FROM Livros";
        return jdbcTemplate.query(sql, this::mapRowToLivro);
    }

    @Override
    public boolean cadastraLivroNovo(Livro livro) {
        String sql = "INSERT INTO Livros (titulo, autor, ano, codigo_usuario) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, livro.getTitulo(), livro.getAutor(), livro.getAno(), -1) > 0;
    }

    @Override
    public boolean removeLivro(long id) {
        String sql = "DELETE FROM Livros WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public List<Livro> getLivrosDoAutor(String autor) {
        String sql = "SELECT * FROM Livros WHERE autor = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Livro(
                rs.getLong("id"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getInt("ano"),
                rs.getLong("codigo_usuario")), autor);
    }

    @Override
    public List<String> getTitulos() {
        String sql = "SELECT titulo FROM Livros";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    @Override
    public Livro getLivroTitulo(long titulo) {
        String sql = "SELECT * FROM Livros WHERE titulo = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Livro(
                rs.getLong("id"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getInt("ano"),
                rs.getLong("codigo_usuario")), titulo);
    }

    @Override
    public List<String> getAutores() {
        String sql = "SELECT DISTINCT autor FROM Livros";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
