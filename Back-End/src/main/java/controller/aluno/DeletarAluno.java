package controller.aluno;

import dao.AlunosDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.ExceptionHandler;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/app/aluno/deletar")

public class DeletarAluno extends HttpServlet {
    AlunosDAO alunosDAO = new AlunosDAO();
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
            String id = req.getParameter("_id");


            //deleta o aluno
            alunosDAO.deletarAluno(id);





            //cria e manda mensagem de sucesso
            StringBuilder message = new StringBuilder();
            message.append("{");
            message.append("\"success\": true,");
            message.append("\"message\": \"Aluno Deletado\"");
            message.append("}");
            out.println(message.toString());

        }catch (Exception e){
            //da print na exception e manda mensagem de erro
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            StringBuilder errorBuilder = new StringBuilder();
            errorBuilder.append("{");
            errorBuilder.append("\"success\": false,");
            errorBuilder.append("\"message\": \"Erro ao deletar aluno\"");
            errorBuilder.append("}");
            out.println(errorBuilder.toString());
        }
        finally {
            out.close();
        }
    }

}
