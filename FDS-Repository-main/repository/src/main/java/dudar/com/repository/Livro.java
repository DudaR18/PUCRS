package dudar.com.repository;

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

    public long getCodigoUsuario() {
        return codigoUsuario; 
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", ano=" + ano + ", codigoUsuario=" + codigoUsuario + "]";
    }
}
