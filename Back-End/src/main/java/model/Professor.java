package model;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;
import util.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    private int idProfessor;
    private List<Integer> disciplinasLecionadas;
    public Professor(String nome,String nomeUsuario,String senha,String tipo,String email,
                     int idProfessor,List<Integer> disciplinasLecionadas){
        super(nome,nomeUsuario,senha,tipo,email);
        this.idProfessor=idProfessor;
        this.disciplinasLecionadas=disciplinasLecionadas;
    }
    public int getIdProfessor(){
        return this.idProfessor;
    }
    public List<Integer> getDisciplinasLecionadas(){
        return this.disciplinasLecionadas;
    }

    public Document paraJson(){
        try {


            JSONObject professorJson = new JSONObject();

            // Dados do usuario
            professorJson.put("nome", super.getNome());
            professorJson.put("nome_usuario", super.getNomeUsuario());
            professorJson.put("senha", super.getSenha());
            professorJson.put("email", super.getEmail());
            professorJson.put("tipo", "professor");


            //dados especificos do professor devem ser salvos em outro json
            JSONObject dadosProfessor = new JSONObject();
            dadosProfessor.put("id_professor", this.idProfessor);

            // tranformando a lista de disciplinasLecionadas para um array para amarzenar
            JSONArray arrayDisciplinas = new JSONArray(this.disciplinasLecionadas);

            // adicionando o array de disciplinas no campo
            dadosProfessor.put("disciplinaLecionadas", arrayDisciplinas);


            professorJson.put("dados_professor", dadosProfessor);


            return Document.parse(professorJson.toString());
        } catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return null;
        }
    }





    public static Professor deJson(Document jsonDoc) {
        try{
            // Extrair dados do usuário
            String nome = jsonDoc.getString("nome");
            String nomeUsuario = jsonDoc.getString("nome_usuario");
            String senha = jsonDoc.getString("senha");
            String email = jsonDoc.getString("email");
            String tipo = jsonDoc.getString("tipo");

            // Extrair dados específicos do professor
            Document dadosProfessor= jsonDoc.get("dados_professor", Document.class);

            int idProfessor = dadosProfessor.getInteger("id_professor");

            // pegando o array de materias lecionadas e transformando em uma List
            List<Integer> disciplinasLecionadas = dadosProfessor.getList("disciplinaLecionadas", Integer.class);

            // garatindo que o array não vai estar vazio e se estiver volta uma lista vazia
            if (disciplinasLecionadas == null) {
                disciplinasLecionadas = new ArrayList<>();
            }



            // Criar e retornar o objeto Aluno
            return new Professor(
                    nome, nomeUsuario, senha, tipo, email,
                    idProfessor, disciplinasLecionadas
            );
        }catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return null;
        }
    }
    @Override
    public String toString() {
        return "Professor{" +
                "idProfessor=" + idProfessor +
                ", disciplinasLecionadas=" + disciplinasLecionadas +
                '}';
    }
}
