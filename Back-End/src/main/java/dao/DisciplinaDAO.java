package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import model.Disciplinas;
import org.bson.Document;
import conexao.Conectar;
import org.bson.types.ObjectId;
import util.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {
    private MongoCollection<Document> colecao;
    Conectar conexao;

    public DisciplinaDAO() {
        this.colecao = conexao.getInstancia().getCollection("Disciplinas");
    }
    public boolean criarDisciplina(Disciplinas disciplinas){
        try {
            disciplinas.setId(ultimoId()+1);
            Document disciplinaJson = disciplinas.paraJson();

            colecao.insertOne(disciplinaJson);
            return true;
        }catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return false;
        }
    }

    public int deletarDisciplina(String id){
        try {


            long deletados;

            ObjectId objectId = new ObjectId(id);

            deletados = colecao.deleteOne(Filters.eq("_id", id)).getDeletedCount();

            if (deletados > 0) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return -1;
        }
    }

    public int atualizarDisciplina(String id, Document json) {
        try {

            ObjectId objectId = new ObjectId(id);


            if (json.containsKey("_id")) {
                json.remove("_id");
            }
            if (json.containsKey("id_disciplina")){
                 Document original = bucarPorObId(id);
                 int idDisciplina = original.getInteger("id_disciplina");
                json.put("id_disciplina", idDisciplina);
            }
            long alterados = colecao.replaceOne(
                    Filters.eq("_id", objectId), json
            ).getModifiedCount();
            if (alterados > 0) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return -1;
        }
    }
    public Document bucarPorId(int id){

        Document filtro = new Document();
        Document disciplina = null;

        filtro.append("id_disciplina",id);

        MongoCursor<Document> cursor = colecao.find(filtro).iterator();

        try{
            while (cursor.hasNext()){
                disciplina = cursor.next();
            }
        } catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        } finally {
            cursor.close();
            return disciplina;
        }
    }


    public Document bucarPorObId(String id){

        Document filtro = new Document();
        Document disciplina = null;

        ObjectId objectId = new ObjectId(id);
        filtro.append("_id", objectId);

        MongoCursor<Document> cursor = colecao.find(filtro).iterator();

        try{
            while (cursor.hasNext()){
                disciplina = cursor.next();
            }
        } catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        } finally {
            cursor.close();
            return disciplina;
        }
    }


    public Document bucarPorNome(String nome){

        Document filtro = new Document();
        Document disciplina = null;

        filtro.append("nome",nome);
        filtro.append("nome",
                new Document("$regex",nome)
                        .append("$options","i"));

        MongoCursor<Document> cursor = colecao.find(filtro).iterator();

        try{
            while (cursor.hasNext()){
                disciplina = cursor.next();
            }
        } catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        } finally {
            cursor.close();
            return disciplina;
        }
    }
    public List<Document> listarDisciplinas(){

        List<Document> listaDisciplina = new ArrayList<>();

        MongoCursor<Document> cursor = colecao.find().iterator();

        try{
            while (cursor.hasNext()){
                listaDisciplina.add(cursor.next());
            }
        } catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        } finally {
            cursor.close();
            return listaDisciplina;
        }
    }

    public int ultimoId(){
        try {
            // ordena por id_disciplina decrescente e pega o primeiro
            Document ultimoDocumento = colecao.find()
                    .sort(Sorts.descending("id_disciplina"))
                    .first();

            if (ultimoDocumento != null) {
                int idDisciplina = ultimoDocumento.getInteger("id_disciplina");
                return idDisciplina;
            }
            return 0; // Se nao achar retorna 0 (primeiro id será 1)
        } catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return -1;
        }
    }
}
