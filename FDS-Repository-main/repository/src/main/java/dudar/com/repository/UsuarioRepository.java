package dudar.com.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioRepository {
    private JdbcTemplate jdbcTemplate;

    public UsuarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Usuario mapRowToUsuario(ResultSet rs, int rowNum) throws SQLException {
        return new Usuario(rs.getLong("codigo"), rs.getString("nome"), rs.getInt("ano_nascimento"));
    }

    public List<Usuario> getAllUsuarios() {
        String sql = "SELECT * FROM Usuarios";
        return jdbcTemplate.query(sql, this::mapRowToUsuario);
    }

    public Usuario getUsuarioById(long codigo) {
        String sql = "SELECT * FROM Usuarios WHERE codigo = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRowToUsuario, codigo);
    }

    public boolean cadastraUsuarioNovo(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (nome, ano_nascimento) VALUES (?, ?)";
        return jdbcTemplate.update(sql, usuario.getNome(), usuario.getAno_nascimento()) > 0;
    }
}
