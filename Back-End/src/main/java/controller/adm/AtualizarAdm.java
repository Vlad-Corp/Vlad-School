package controller.adm;

import dao.AdmDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Adm;
import org.bson.Document;
import util.ExceptionHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/app/adm/atualizar")

public class AtualizarAdm extends HttpServlet {
    AdmDAO admDAO = new AdmDAO();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // classe necessaria para escrever no http e mandar o json de resposta
        PrintWriter out = resp.getWriter();




        //muda de html para json
        resp.setContentType("application/json");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //json que vai ser utilizado para atualizar o usuario no banco
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


            //objeto que o metodo atualizar utiliza
            //convert json string para json bson, e depois para um objeto adm
            Adm adm = Adm.deJson(Document.parse(jsonString));


            //pega o id para indentificar oq atualizar
            String id = req.getParameter("_id");

            //atualiza o adm
            admDAO.atualizarAdm(id, adm.paraJson());


            //cria e manda mensagem de sucesso
            StringBuilder message = new StringBuilder();
            message.append("{");
            message.append("\"success\": true,");
            message.append("\"message\": \"Adm atualizado\",");
            message.append("\"causa\": \"").append(adm.getNome()).append("\"");
            message.append("}");
            out.println(message.toString());

        }catch (Exception e){
            //da print na exception e manda mensagem de erro
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            StringBuilder errorBuilder = new StringBuilder();
            errorBuilder.append("{");
            errorBuilder.append("\"success\": false,");
            errorBuilder.append("\"message\": \"Erro ao atualizar adm\",");
            errorBuilder.append("\"causa\": \"").append(e.getMessage()).append("\"");
            errorBuilder.append("}");
            out.println(errorBuilder.toString());
        }
        finally {
            out.close();
        }
    }

}
