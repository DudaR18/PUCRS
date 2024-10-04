package com.dudar.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private AcervoRepository livros;
    private UsuarioRepository usuarios;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Controller(AcervoRepository livros, UsuarioRepository usuarios, JdbcTemplate jdbcTemplate) {
        this.livros = livros;
        this.usuarios = usuarios;
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String mensagemDeBemVindo() {
        return "Bem vindo a biblioteca central! Dicas em: /dicas";
    }

    @GetMapping("/dicas")
    public String dicas(){
        return"\n" + //
                        " --- Retirar Livro: /livros/retirar/{id}/{codigoUsuario}" + //
                        " --- Devolver Livro: /livros/devolver/{id}" + //
                        " --- Livros Não-Emprestados: /livros/nao-emprestados"  + // 
                        " --- Livros Emprestados: /livros/emprestados/{codigoUsuario}" + // 
                        " --- Usuário por ID: /usuarios/{codigo}"  + // 
                        " --- Usuários: /usuarios";
    }
    @PostMapping("/livros/retirar/{id}/{codigoUsuario}")
    public boolean retirarLivro(@PathVariable long id, @PathVariable long codigoUsuario) {
        return livros.retirarLivro(id, codigoUsuario);
    }

    @PostMapping("/livros/devolver/{id}")
    public boolean devolverLivro(@PathVariable long id) {
        return livros.devolverLivro(id);
    }

    @GetMapping("/livros/nao-emprestados")
    public List<Livro> listarLivrosNaoEmprestados() {
        return livros.listarLivrosNaoEmprestados();
    }

    @GetMapping("/livros/emprestados/{codigoUsuario}")
    public List<Livro> listarLivrosEmprestadosParaUsuario(@PathVariable long codigoUsuario) {
        return livros.listarLivrosEmprestadosParaUsuario(codigoUsuario);
    }

    @GetMapping("/usuarios/{codigo}")
    public Usuario getUsuarioById(@PathVariable long codigo) {
        return usuarios.getUsuarioById(codigo);
    }

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarios.getAllUsuarios();
    }

