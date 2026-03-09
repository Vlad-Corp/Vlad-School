package dao;

import com.mongodb.client.*;
import com.mongodb.client.model.*;
import model.Aluno;
import model.Notas;
import org.bson.Document;
import java.util.*;
import conexao.Conectar;
import org.bson.types.ObjectId;
import util.ExceptionHandler;

public class AlunosDAO {

    private MongoCollection<Document> colecao;
    private Conectar conexao;

    public AlunosDAO() {
        this.colecao = conexao.getInstancia().getCollection("Usuarios");
    }



    public boolean criarAluno(Aluno aluno){
        try {
            if (aluno.getNotas().size()>2){
                while (aluno.getNotas().size() > 2) {
                    aluno.getNotas().remove(aluno.getNotas().size() - 1); // Remove a última
                }
            }

            for (int i = 0; i < aluno.getNotas().size(); i++) {
                if (aluno.getNotas().get(i) == null) {
                    aluno.getNotas().set(i, new Notas(-1, -1, 0, "null"));
                }
            }

            Document alunoJson = aluno.paraJson();
            colecao.insertOne(alunoJson);
            return true;
        }catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return false;
        }
    }

    public int deletarAluno(String id){
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

    public int atualizarAluno(String id, Document json) {
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




        public List<Document> buscarPorNome(String nome){
        List<Document> alunos = new ArrayList<>();
        Document filtro = new Document();
        filtro.append("tipo", "aluno");      // Filtra pelo tipo
        filtro.append("nome",
                new Document("$regex", nome)  // Procura a string em qualquer posição
                        .append("$options", "i"));
        MongoCursor<Document> cursor = colecao.find(filtro).iterator();
        try {


            //insere no json
            while (cursor.hasNext()) {
                alunos.add(cursor.next());
            }
        }catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        }
        finally {
            cursor.close();
            return alunos;
        }
    }


    public List<Document> buscarPorStatus(String status){
        Document filtro = new Document();
        List<Document> alunos = new ArrayList<>();
        filtro.append("tipo", "aluno");
        filtro.append("dados_aluno.status", status);
        MongoCursor<Document> cursor = colecao.find(filtro).iterator();
        try {


            //insere no json
            while (cursor.hasNext()) {
                alunos.add(cursor.next());
            }
        }catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        }
        finally {
            cursor.close();
            return alunos;
        }
    }

    public List<Document> buscarPorId(String id){
        Document filtro = new Document();
        List<Document> alunos = new ArrayList<>();
        filtro.append("tipo", "aluno");
        ObjectId objectId = new ObjectId(id);
        filtro.append("_id", objectId);
        MongoCursor<Document> cursor = colecao.find(filtro).iterator();
        try {
            //insere no json
            while (cursor.hasNext()) {
                alunos.add(cursor.next());
            }
        }catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        }
        finally {
            cursor.close();
            return alunos;
        }
    }


    public List<Document> buscarPorSerie(String serie){
        Document filtro = new Document();
        List<Document> alunos = new ArrayList<>();
        filtro.append("tipo", "aluno");
        filtro.append("dados_aluno.serie", serie);
        MongoCursor<Document> cursor = colecao.find(filtro).iterator();
        try {


            //insere no json
            while (cursor.hasNext()) {
                alunos.add(cursor.next());
            }
        }catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        }
        finally {
            cursor.close();
            return alunos;
        }
    }

    public List<Document> buscarPorIndex(int index){
        Document filtro = new Document();
        List<Document> alunos = new ArrayList<>();
        int numPorPagina = 10;
        filtro.append("tipo", "aluno");
        int pular = numPorPagina * index;

        MongoCursor<Document> cursor = colecao.find(filtro)
                .skip(pular)          // pula os registros das páginas anteriores
                .limit(numPorPagina) // limita a 10 resultados
                .iterator();
        try {


            //insere no json
            while (cursor.hasNext()) {
                alunos.add(cursor.next());
            }
        }catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        }
        finally {
            cursor.close();
            return alunos;
        }
    }

    public boolean logar(String email, String senha){
        Document filtro = new Document();
        filtro.append("tipo", "aluno");
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
        List<Document> alunos = new ArrayList<>();
        filtro.append("tipo", "aluno");
        filtro.append("email", email);
        MongoCursor<Document> cursor = colecao.find(filtro).iterator();
        try {
            //insere no json
            while (cursor.hasNext()) {
                alunos.add(cursor.next());
            }
        }catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        }
        finally {
            cursor.close();
            return alunos;
        }
    }


}
