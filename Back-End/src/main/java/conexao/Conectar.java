package conexao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import util.Env;

public class Conectar {
    //caso alguem tente abrir outra conexao a classe usa a ja aberta
    private static Conectar instancia;


    private MongoClient cliente;
    private MongoDatabase database;

    public Conectar() {
        conectar();
    }

    // Metodo para saber se ja tem uma instancia do objeto
    public static Conectar getInstancia() {
        if (instancia == null) {
            instancia = new Conectar();
        }
        return instancia;
    }

    private void conectar(){
        try {
            //dados de login no db
            Env env = new Env();
            String urlConexao = env.getUrlConexao();
            String DBName = env.getDBName();

            //conecta o cliente
            this.cliente = MongoClients.create(urlConexao);
            this.database = cliente.getDatabase(DBName);

            System.out.println("Conectado a "+database);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //getters
    public MongoClient getCliente() {
        return cliente;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    //metodo que pega colecao

    public MongoCollection<Document> getCollection(String nome) {
        return database.getCollection(nome);
    }

    // Fechar conexão
    public void fechar() {
        //verifica se tem conexao para fechar
        if (cliente != null) {
            cliente.close();
            System.out.println("Fechado");
        }
        else{
            System.out.println("não há conexao");
        }
    }
}
