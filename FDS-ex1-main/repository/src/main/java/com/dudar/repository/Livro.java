package com.dudar.repository;

public class Livro {
    private long id;
    private String titulo;
    private String autor;
    private int ano;
    private long codigoUsuario;

    public Livro(long id, String titulo, String autor, int ano, long codigoUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.codigoUsuario = codigoUsuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", ano=" + ano + ", codigoUsuario="
                + codigoUsuario + "]";
    }
}
