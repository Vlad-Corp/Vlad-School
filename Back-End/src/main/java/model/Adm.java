package model;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;
import util.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class Adm extends Usuario {

    public Adm(String nome,String nomeUsuario,String senha,String tipo,String email){
        super(nome,nomeUsuario,senha,tipo,email);

    }


    public Document paraJson(){
        try {


            JSONObject admJson = new JSONObject();

            // Dados do usuario
            admJson.put("nome", super.getNome());
            admJson.put("nome_usuario", super.getNomeUsuario());
            admJson.put("senha", super.getSenha());
            admJson.put("email", super.getEmail());
            admJson.put("tipo", "adm");




            return Document.parse(admJson.toString());
        } catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return null;
        }
    }





    public static Adm deJson(Document jsonDoc) {
        try{
            // Extrair dados do usuário
            String nome = jsonDoc.getString("nome");
            String nomeUsuario = jsonDoc.getString("nome_usuario");
            String senha = jsonDoc.getString("senha");
            String email = jsonDoc.getString("email");
            String tipo = jsonDoc.getString("tipo");





            // Criar e retornar o objeto Aluno
            return new Adm(
                    nome, nomeUsuario, senha, tipo, email
            );
        }catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Adm{}";
    }
}
