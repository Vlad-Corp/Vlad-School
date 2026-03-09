package controller.professor;

import dao.ProfessorDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.ExceptionHandler;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/app/professor/deletar")
public class DeletarProfessor extends HttpServlet {
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

            //pega _id para deletar o professor
            String id = req.getParameter("_id");


            //deleta o professor
            professorDAO.deletarProfessor(id);


            //cria e manda mensagem de sucesso
            StringBuilder message = new StringBuilder();
            message.append("{");
            message.append("\"success\": true,");
            message.append("\"message\": \"Professor Deletado\"");
            message.append("}");
            out.println(message.toString());

        }catch (Exception e){
            //da print na exception e manda mensagem de erro
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            StringBuilder errorBuilder = new StringBuilder();
            errorBuilder.append("{");
            errorBuilder.append("\"success\": false,");
            errorBuilder.append("\"message\": \"Erro ao deleta professor\"");
            errorBuilder.append("}");
            out.println(errorBuilder.toString());
        }
        finally {
            out.close();
        }
    }
}
