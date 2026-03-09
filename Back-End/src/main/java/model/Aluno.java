package model;

import org.bson.Document;
import org.json.JSONObject;
import org.json.JSONArray;
import util.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private String matricula;
    private String serie;
    private String status;
    private List<Notas> notas;
    private List<Observacoes> observacoes;


    public Aluno(String nome,String nomeUsuario,String senha,String tipo,String email, String matricula,
                 String serie, String status, List<Notas> notas, List<Observacoes> observacoes){
        super(nome,nomeUsuario,senha,tipo,email);
        this.matricula=matricula;
        this.serie=serie;
        this.status=status;
        this.notas=notas;
        this.observacoes=observacoes;
    }

    public Aluno(String nome, String nomeUsuario, String senha, String tipo, String email,
                 String matricula, String serie, String status) {
        super(nome, nomeUsuario, senha, tipo, email);
        this.matricula = matricula;
        this.serie = serie;
        this.status = status;
        this.notas = new ArrayList<>();
        this.observacoes = new ArrayList<>();
    }




    public String getMatricula(){
        return this.matricula;
    }
    public String getSerie(){
        return this.serie;
    }
    public String getStatus(){
        return this.status;
    }
    public List<Notas> getNotas(){
        return this.notas;
    }
    public List<Observacoes> getObservacoes(){
        return this.observacoes;
    }


    public Document paraJson(){
        try {


            JSONObject alunoJson = new JSONObject();

            // Dados do user
            alunoJson.put("nome", super.getNome());
            alunoJson.put("nome_usuario", super.getNomeUsuario());
            alunoJson.put("senha", super.getSenha());
            alunoJson.put("email", super.getEmail());
            alunoJson.put("tipo", "aluno");


            //dados especificos do aluno devem ser salvos em outro json
            JSONObject dadosAluno = new JSONObject();
            dadosAluno.put("matricula", this.matricula);
            dadosAluno.put("serie", this.serie);
            dadosAluno.put("status", this.status);


            // notas
            JSONArray notasArray = new JSONArray();
            if (this.notas != null) {
                for (Notas nota : this.notas) {
                    JSONObject notaJson = new JSONObject();
                    notaJson.put("periodo", nota.getPeriodo());
                    notaJson.put("id_professor", nota.getIdProfessor());
                    notaJson.put("id_disciplina", nota.getIdDisciplina());
                    notaJson.put("nota", nota.getNota());
                    notasArray.put(notaJson);
                }
            }

            JSONArray observacoesArray = new JSONArray();
            if (this.observacoes != null) {
                for (Observacoes obs : this.observacoes) {
                    JSONObject obsJson = new JSONObject();
                    obsJson.put("id_professor", obs.getIdProfessor());
                    obsJson.put("data", obs.getData());
                    obsJson.put("observacao", obs.getObservacao());
                    observacoesArray.put(obsJson);
                }
            }
            dadosAluno.put("notas", notasArray);
            dadosAluno.put("observacoes", observacoesArray);

            alunoJson.put("dados_aluno", dadosAluno);


            return Document.parse(alunoJson.toString());
        } catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return null;
        }
    }





    public static  Aluno  deJson(Document jsonDoc) {
        try{
        // Extrair dados do usuário
        String nome = jsonDoc.getString("nome");
        String nomeUsuario = jsonDoc.getString("nome_usuario");
        String senha = jsonDoc.getString("senha");
        String email = jsonDoc.getString("email");
        String tipo = jsonDoc.getString("tipo");

        // Extrair dados específicos do aluno
        Document dadosAluno = jsonDoc.get("dados_aluno", Document.class);

        String matricula = dadosAluno.getString("matricula");
        String serie = dadosAluno.getString("serie");
        String status = dadosAluno.getString("status");

        // Processar notas
        List<Notas> notasList = new ArrayList<>();
        List<Document> notasDocs = (List<Document>) dadosAluno.get("notas");
        if (notasDocs != null) {
            for (Document notaDoc : notasDocs) {
                Notas nota = new Notas(
                        notaDoc.getInteger("id_professor"),
                        notaDoc.getInteger("id_disciplina"),
                        notaDoc.get("nota", Number.class).doubleValue(),
                        notaDoc.getString("periodo")
                );
                notasList.add(nota);
            }
        }

        // Processar observações
        List<Observacoes> obsList = new ArrayList<>();
        List<Document> obsDocs = (List<Document>) dadosAluno.get("observacoes");
        if (obsDocs != null) {
            for (Document obsDoc : obsDocs) {
                Observacoes obs = new Observacoes(
                        obsDoc.getInteger("id_professor"),
                        obsDoc.getString("data"),
                        obsDoc.getString("observacao")
                );
                obsList.add(obs);
            }
        }

        // Criar e retornar o objeto Aluno
        return new Aluno(
                nome, nomeUsuario, senha, tipo, email,
                matricula, serie, status, notasList, obsList
        );
        }catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return null;
        }
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"nome\": \"" + super.getNome() + "\",\n" +
                "  \"nomeUsuario\": \"" + super.getNomeUsuario() + "\",\n" +
                "  \"email\": \"" + super.getEmail() + "\",\n" +
                "  \"tipo\": \"" + super.getTipo() + "\",\n" +
                "  \"matricula\": \"" + matricula + "\",\n" +
                "  \"serie\": \"" + serie + "\",\n" +
                "  \"status\": \"" + status + "\",\n" +
                "  \"notas\": " + (notas != null ? notas : "[]") + ",\n" +
                "  \"observacoes\": " + (observacoes != null ? observacoes : "[]") + "\n" +
                "}";
    }

}
