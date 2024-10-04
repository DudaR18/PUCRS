package dudar.com.repository;

public class Usuario {
    private long codigo;
    private String nome;
    private int ano_nascimento;

    public Usuario( long codigo, String nome, int ano_nascimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.ano_nascimento = ano_nascimento;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getAno_nascimento() {
        return ano_nascimento;
    }

    @Override
    public String toString() {
        return "Usuario [codigo=" + codigo + ", nome=" + nome + ", ano_nascimento=" + ano_nascimento + "]";
    }

}
