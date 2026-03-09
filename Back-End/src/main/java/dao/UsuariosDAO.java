package dao;

import com.mongodb.client.*;
import com.mongodb.client.model.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.*;
import conexao.Conectar;

public class UsuariosDAO {
    private MongoCollection<Document> colecao;

    public UsuariosDAO() {
        this.colecao = Conectar.getInstancia().getCollection("Usuarios");
    }

    public List<Document> buscar(){
        List<Document> resultados = new ArrayList<>();

            colecao.find().forEach(resultados::add);
            return resultados;
        }


    public List<Document> buscarFiltro(Map<String, String> filtros) {
        List<Document> resultados = new ArrayList<>();
        List<Bson> condicoes = new ArrayList<>();

        for (Map.Entry<String, String> entry : filtros.entrySet()) {
            String campo = entry.getKey();
            String valor = entry.getValue();

            // Filtro básico: campo = valor
            condicoes.add(Filters.eq(campo, valor));
        }
        colecao.find(Filters.and(condicoes)).forEach(resultados::add);

        return resultados;

    }

    public List<Document> buscarFiltroAll(String texto) {
        List<Document> resultados = new ArrayList<>();

        // Filtro usando busca textual nativa
        Bson filtro = Filters.text(texto);

        // Executa a query com ordenação
        colecao.find(filtro)
                .projection(Projections.metaTextScore("score"))
                .sort(Sorts.metaTextScore("score"))
                .forEach(resultados::add);

        return resultados;
    }

    public List<Document> buscarLike(Map<String, String> filtros) {
        List<Document> resultados = new ArrayList<>();

        List<Bson> condicoes = new ArrayList<>();

        for (Map.Entry<String, String> filtro : filtros.entrySet()) {
            String valor = filtro.getValue();
            if (valor != null && !valor.isEmpty()) {
                // campo contém o valor
                condicoes.add(Filters.regex(filtro.getKey(), valor, "i"));
            }
        }

        if (!condicoes.isEmpty()) {
            colecao.find(Filters.and(condicoes)).into(resultados);
        }

        return resultados;
    }

    public List<Document> buscarEmTodosCamposComLike(String texto) {
        List<Document> resultados = new ArrayList<>();

        Set<String> campos = obterCamposDaColecao();
        List<Bson> condicoes = new ArrayList<>();

        for (String campo : campos) {
            condicoes.add(Filters.regex(campo, texto, "i"));
        }

        if (!condicoes.isEmpty()) {
            Bson filtro = Filters.or(condicoes);
            colecao.find(filtro).into(resultados);
        }

        return resultados;
    }

    private Set<String> obterCamposDaColecao() {
        Set<String> campos = new HashSet<>();


        FindIterable<Document> amostra = colecao.find().limit(10);

        for (Document doc : amostra) {
            campos.addAll(doc.keySet());
        }

        return campos;
    }

}

