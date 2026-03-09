package controller.professor;

import dao.ProfessorDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Professor;
import org.bson.Document;
import util.ExceptionHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/app/professor/enviarObservacao")
public class EnviarObservacaoProfessor extends HttpServlet {
    ProfessorDAO professorDAO = new ProfessorDAO();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // classe necessaria para escrever no http e mandar o json de resposta
        PrintWriter out = resp.getWriter();

        //muda de html para json
        resp.setContentType("application/json");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //try de erro
        try {

            //pega o id para indentificar oq atualizar
            String idAluno = req.getParameter("idAluno");
            int idProfessor = Integer.parseInt(req.getParameter("idProfessor"));
            String textoObservacao = req.getParameter("textoObservacao");


            //envia as observações
            professorDAO.enviarObservacao(idAluno,idProfessor,textoObservacao);


            //cria e manda mensagem de sucesso
            StringBuilder message = new StringBuilder();
            message.append("{");
            message.append("\"success\": true,");
            message.append("\"message\": \"Observação enviada\",");
            message.append("\"causa\": \"").append(textoObservacao).append("\"");
            message.append("}");
            out.println(message.toString());

        }catch (Exception e){
            //da print na exception e manda mensagem de erro
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            StringBuilder errorBuilder = new StringBuilder();
            errorBuilder.append("{");
            errorBuilder.append("\"success\": false,");
            errorBuilder.append("\"message\": \"Erro aenviar observacao" +
                    "\",");
            errorBuilder.append("\"causa\": \"").append(e.getMessage()).append("\"");
            errorBuilder.append("}");
            out.println(errorBuilder.toString());
        }
        finally {
            out.close();
        }
    }
}
