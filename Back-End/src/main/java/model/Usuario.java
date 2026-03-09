package model;

public abstract class Usuario {
    private String nome;
    private String nomeUsuario;
    private String senha;
    private String tipo;
    private String email;
    public Usuario(String nome,String nomeUsuario,String senha,String tipo,String email){
        this.nome=nome;
        this.nomeUsuario=nomeUsuario;
        this.senha=senha;
        this.tipo=tipo;
        this.email=email;
    }
    public String getNome(){
        return this.nome;
    }
    public String getNomeUsuario(){
        return this.nomeUsuario;
    }
    public String getSenha(){
        return this.senha;
    }
    public String getEmail(){
        return this.email;
    }
    public String getTipo() {return tipo;}

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", senha='" + senha + '\'' +
                ", tipo='" + tipo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
