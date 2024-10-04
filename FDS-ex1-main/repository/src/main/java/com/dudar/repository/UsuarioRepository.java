package com.dudar.repository;

import java.util.List;

public interface UsuarioRepository {
    Usuario getUsuarioById(long codigo);
    boolean cadastraUsuarioNovo(Usuario usuario);
    List<Usuario> getAllUsuarios();
    boolean removeUsuario(long codigo);
}
