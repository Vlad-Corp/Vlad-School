package controller.aluno;

import dao.AlunosDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/app/aluno/logar")

public class    LogarAluno extends HttpServlet {
    AlunosDAO alunosDAO = new AlunosDAO();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {





        //muda de html para json
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // classe necessaria para escrever no http e mandar o json
        PrintWriter out = resp.getWriter();

        //carrega um json modelo
        Document modelo = new Document();


        //pega os parametros

        //json que vai ser utilizado para verificar dados
        StringBuilder jsonBuilder = new StringBuilder(); // json em si (O string builder é a versão melhorada da String, pq é mutavel ent n cria objetos desncessarios na memoria acada mudança)
        String line; // linha do json (variavel temporaria)

        try (BufferedReader reader = req.getReader()) { // o buffer reader serve justamente para ler a
        // Le a primeira linha do corpo da requisição
        // Se nao tiver mais linhas retorna null
        while ((line = reader.readLine()) != null) {
            // Adiciona cada linha ao StringBuilder
            jsonBuilder.append(line);
        }

    }
        //Converte de json String Builder(mutavel) para jsonString(Imutavel)
        String jsonString = jsonBuilder.toString();


        String email = Document.parse(jsonString).getString("email");
        String senha = Document.parse(jsonString).getString("senha");




        //pesquisa e retorna se a pessoa pode logar
        boolean retorno = alunosDAO.logar(email, senha);
        modelo.append("retorno", retorno);
        out.println(modelo.toJson());



    }

}
