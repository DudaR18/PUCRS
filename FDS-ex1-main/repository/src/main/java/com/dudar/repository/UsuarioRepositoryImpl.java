package com.dudar.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UsuarioRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Usuario mapRowToUsuario(ResultSet rs, int rowNum) throws SQLException {
        return new Usuario(
                rs.getLong("codigo"),
                rs.getString("nome"),
                rs.getInt("ano_nascimento")
        );
    }

    @Override
    public Usuario getUsuarioById(long codigo) {
        String sql = "SELECT * FROM Usuarios WHERE codigo = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRowToUsuario, codigo);
    }

    @Override
    public boolean cadastraUsuarioNovo(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (nome, ano_nascimento) VALUES (?, ?)";
        return jdbcTemplate.update(sql, usuario.getNome(), usuario.getAnoNascimento()) > 0;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        String sql = "SELECT * FROM Usuarios";
        return jdbcTemplate.query(sql, this::mapRowToUsuario);
    }

    @Override
    public boolean removeUsuario(long codigo) {
        String sql = "DELETE FROM Usuarios WHERE codigo = ?";
        return jdbcTemplate.update(sql, codigo) > 0;
    }
}

