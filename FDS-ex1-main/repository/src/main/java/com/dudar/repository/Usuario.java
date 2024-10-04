package com.dudar.repository;

public class Usuario {
    private long codigo;
    private String nome;
    private int anoNascimento;

    public Usuario(long codigo, String nome, int anoNascimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    @Override
    public String toString() {
        return "Usuario [codigo=" + codigo + ", nome=" + nome + ", anoNascimento=" + anoNascimento + "]";
    }

   
}

