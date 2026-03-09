package controller.disciplina;

import jakarta.servlet.http.HttpServlet;
import dao.DisciplinaDAO;

import model.Disciplinas;
import util.ExceptionHandler;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/app/disciplina/criar")
public class CriarDisciplina extends HttpServlet {

    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // classe necessaria para escrever no http e mandar o json de resposta
        PrintWriter out = resp.getWriter();

        //muda de html para json
        resp.setContentType("application/json");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //json que vai ser utilizado para criar o usuario no banco
        StringBuilder jsonBuilder = new StringBuilder(); // json em si (O string builder é a versão melhorada da String, pq é mutavel ent n cria objetos desncessarios na memoria acada mudança)
        String line; // linha do json (variavel temporaria)

        //try de erro
        try {


            //Le o json e cria ele no java, o try serve para fechar o leito caso n tenha nada (BRUTAL)
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


            //convert json string para json bson, e depois para um objeto Disciplina
            Disciplinas disciplina = Disciplinas.deJson(Document.parse(jsonString));


            //cria a disciplina
            disciplinaDAO.criarDisciplina(disciplina);


            //cria e manda mensagem de sucesso
            StringBuilder message = new StringBuilder();
            message.append("{");
            message.append("\"success\": true,");
            message.append("\"message\": \"disciplina criada\",");
            message.append("\"causa\": \"").append(disciplina.getNome()).append("\"");
            message.append("}");
            out.println(message.toString());

        }catch (Exception e){
            //da print na exception e manda mensagem de erro
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            StringBuilder errorBuilder = new StringBuilder();
            errorBuilder.append("{");
            errorBuilder.append("\"success\": false,");
            errorBuilder.append("\"message\": \"Erro ao criar disciplina\",");
            errorBuilder.append("\"causa\": \"").append(e.getMessage()).append("\"");
            errorBuilder.append("}");
            out.println(errorBuilder.toString());
        }
        finally {
            out.close();
        }
    }
}
