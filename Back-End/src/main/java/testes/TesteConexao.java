package testes;

import conexao.Conectar;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.*;

//TUDO AQUI É FEITO POR IA
public class TesteConexao {
    public static void main(String[] args) {
        System.out.println("🧪 INICIANDO TESTE DE CONEXÃO MONGODB");
        System.out.println("======================================");

        try {
            //Testa conexão
            System.out.println("\n1. 🔗 Testando conexão...");
            MongoCollection<Document> alunos = Conectar.getInstancia().getCollection("Usuarios");
            System.out.println("   ✅ Conexão estabelecida!");
            System.out.println("   📊 Coleção: Usuarios");

            // Conta documentos
            long total = alunos.countDocuments();
            System.out.println("\n2. 📈 Contando documentos...");
            System.out.println("   Total de Usuarios: " + total);

        } catch (Exception e) {
            System.err.println("Mensagem: " + e.getMessage());
            e.printStackTrace();
        }
    }
}