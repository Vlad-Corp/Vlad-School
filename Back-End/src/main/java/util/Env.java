package util;

import io.github.cdimascio.dotenv.Dotenv;

public class Env {
    String urlConexao;
    String DBName;
    String Email;
    String Senha;
    public Env() {
        Dotenv env = Dotenv.load();
        this.urlConexao = env.get("CONNECTION_STRING");
        this.DBName = env.get("DB_NAME");
        this.Email = env.get("EMAIL");
        this.Senha =  env.get("SENHA");
 }

    public String getUrlConexao(){
        return this.urlConexao;
    }

    public String getDBName(){
        return this.DBName;
    }

    public String getSenha() {
        return Senha;
    }

    public String getEmail() {
        return Email;
    }
}
