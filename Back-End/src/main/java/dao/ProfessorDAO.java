package dao;

import com.mongodb.client.*;
import com.mongodb.client.model.*;
import model.Aluno;
import model.Notas;
import model.Professor;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.time.LocalDate;
import java.util.*;
import conexao.Conectar;
import org.bson.types.ObjectId;
import util.ExceptionHandler;

public class ProfessorDAO {

    private MongoCollection<Document> colecao;
    private Conectar conexao;

    public ProfessorDAO() {
        this.colecao = conexao.getInstancia().getCollection("Usuarios");
    }

    public boolean criarProfessor(Professor professor){
        try {



            Document professorJson = professor.paraJson();
            colecao.insertOne(professorJson);
            return true;
        }catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return false;
        }
    }


    public List<Document> buscarPorNome(String nome) {
        List<Document> professores = new ArrayList<>();
        Document filtro = new Document();
        filtro.append("tipo", "professor");
        filtro.append("nome",
                new Document("$regex", nome)
                        .append("$options", "i"));
        MongoCursor<Document> cursor = colecao.find(filtro).iterator();
        try {

            while (cursor.hasNext()) {
                professores.add(cursor.next());
            }
        } catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        } finally {
            cursor.close();
            return professores;
        }
    }

    public List<Document> buscarPorIdProfessor(int id) {
        List<Document> professores = new ArrayList<>();
        Document filtro = new Document();
        filtro.append("tipo", "professor");
        filtro.append("dados_professor.id_professor",id);
        MongoCursor<Document> cursor = colecao.find(filtro).iterator();
        try {

            while (cursor.hasNext()) {
                professores.add(cursor.next());
            }
        } catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        } finally {
            cursor.close();
            return professores;
        }
    }


    public List<Document> buscarPorObId(String id){
        Document filtro = new Document();
        List<Document> professores = new ArrayList<>();
        filtro.append("tipo", "professor");
        ObjectId objectId = new ObjectId(id);
        filtro.append("_id", objectId);
        MongoCursor<Document> cursor = colecao.find(filtro).iterator();
        try {
            //insere no json
            while (cursor.hasNext()) {
                professores.add(cursor.next());
            }
        }catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        }
        finally {
            cursor.close();
            return professores;
        }
    }

    public List<Document> listarProfessores() {
        List<Document> professores = new ArrayList<>();

        MongoCursor<Document> cursor = colecao.find(
                Filters.eq("tipo", "professor")).iterator();

        try {
            while (cursor.hasNext()) {
                professores.add(cursor.next());
            }
        } catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        } finally {
            cursor.close();
            return professores;
        }
    }

    public List<Document> buscarPorDisciplina(int idDisciplina) {
        List<Document> professores = new ArrayList<>();
        try (MongoCursor<Document> cursor = colecao.find(
                Filters.and(
                        Filters.eq("tipo", "professor"),
                        Filters.in("dados_professor.disciplinaLecionadas", idDisciplina))).iterator()) {
            while (cursor.hasNext()) {
                professores.add(cursor.next());
            }
        } catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        }
        return professores;
    }


    public int enviarObservacao(String idAluno, int idProfessor, String textoObservacao) {
        try {
            ObjectId alunoId = new ObjectId(idAluno);

            Document observacao = new Document();
            observacao.append("id_professor", idProfessor);
            observacao.append("data", LocalDate.now().toString());
            observacao.append("observacao", textoObservacao);

            Document update = new Document(
                    "$push", // leva as informações pro Array
                    new Document("dados_aluno.observacoes", observacao)
            );

            long alterados = colecao.updateOne(
                    Filters.and(
                            Filters.eq("_id", alunoId),
                            Filters.eq("tipo", "aluno")
                    ),
                    update
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

    public int deletarProfessor(String id) {
        try {


            long deletados;
            ObjectId objectId = new ObjectId(id);

            deletados = colecao.deleteOne(Filters.eq("_id", objectId)).getDeletedCount();

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

    public int atualizarProfessor(String id, Document json) {
        try {
            ObjectId objectId = new ObjectId(id);

            if (json.containsKey("_id")) {
                json.remove("_id");
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


    public boolean logar(String email, String senha){
        Document filtro = new Document();
        filtro.append("tipo", "professor");
        filtro.append("email", email);
        filtro.append("senha", senha);
        MongoCursor<Document> cursor = colecao.find(filtro).iterator();
        try {
            if (cursor.hasNext()){
                return true;
            }
            return false;
        }
        finally {
            cursor.close();
        }
    }


    public List<Document> buscarPorEmail(String email){
        Document filtro = new Document();
        List<Document> professores = new ArrayList<>();
        filtro.append("tipo", "professor");
        filtro.append("email", email);
        MongoCursor<Document> cursor = colecao.find(filtro).iterator();
        try {
            //insere no json
            while (cursor.hasNext()) {
                professores.add(cursor.next());
            }
        }catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        }
        finally {
            cursor.close();
            return professores;
        }
    }


}

