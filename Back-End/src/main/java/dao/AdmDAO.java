package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import conexao.Conectar;
import org.bson.Document;
import org.bson.types.ObjectId;
import util.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class AdmDAO {
    private MongoCollection<Document> colecao;
    private Conectar conexao;
    public AdmDAO() {
        this.colecao = conexao.getInstancia().getCollection("Usuarios");
    }
    public boolean logar(String email, String senha){
        Document filtro = new Document();
        filtro.append("tipo", "adm");
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
        filtro.append("tipo", "adm");
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

    public int atualizarAdm(String id, Document json) {
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
}
