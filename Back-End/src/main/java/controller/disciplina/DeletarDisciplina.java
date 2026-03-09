package controller.disciplina;

import dao.AlunosDAO;
import jakarta.servlet.http.HttpServlet;
import dao.DisciplinaDAO;
import util.ExceptionHandler;
import util.JsonLoader;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.Document;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

    @WebServlet("/app/disciplina/deletar")
public class DeletarDisciplina extends HttpServlet {
    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
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

            //pega _id para deletar o aluno
            String id = req.getParameter("id");

            //deleta a disciplina
            disciplinaDAO.deletarDisciplina(id);

            //cria e manda mensagem de sucesso
            StringBuilder message = new StringBuilder();
            message.append("{");
            message.append("\"success\": true,");
            message.append("\"message\": \"Disciplina Deletado\"");
            message.append("}");
            out.println(message.toString());

        }catch (Exception e){
            //da print na exception e manda mensagem de erro
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            StringBuilder errorBuilder = new StringBuilder();
            errorBuilder.append("{");
            errorBuilder.append("\"success\": false,");
            errorBuilder.append("\"message\": \"Erro ao deletar disciplina\"");
            errorBuilder.append("}");
            out.println(errorBuilder.toString());
        }
        finally {
            out.close();
        }
    }
}
