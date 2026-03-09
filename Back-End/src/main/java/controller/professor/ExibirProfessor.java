package controller.professor;

import dao.ProfessorDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.Document;
import util.JsonLoader;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/app/professor/exibir")
public class ExibirProfessor extends HttpServlet {
    ProfessorDAO professorDAO = new ProfessorDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {


        //lista de professor, todos os metodos de busca retornam isso
        List<Document> listaProfessor;


        //muda de html para json
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // classe necessaria para escrever no http e mandar o json
        PrintWriter out = resp.getWriter();

        //carrega um json modelo
        Document modelo = JsonLoader.carregar("Jsons/modelJson.json");
        Document professores = modelo;

        //pega qual tipo de busca a requisiçao quer
        String tipo =  req.getParameter("tipo");


        //compara as buscas
        if (tipo==null){
            out.println(modelo.toJson());
        } else if (tipo.equals("nome")){

            //busca por nome
            String nome = req.getParameter("nome");

            //pesquisa no banco
            listaProfessor = professorDAO.buscarPorNome(nome);

            //coloca tuda a lista de professores( que é na verdade uma lista de jsons) em uma array no json
            professores.put("professores", listaProfessor);
            out.println(professores.toJson());

        } else if (tipo.equals("listar")) {

            // retorna todos os professores
            listaProfessor = professorDAO.listarProfessores();

            //coloca tuda a lista de professores( que é na verdade uma lista de jsons) em uma array no json
            professores.put("professores", listaProfessor);
            out.println(professores.toJson());
        } else if (tipo.equals("disciplina")) {

            //pega na requisição o id das disciplinas lecionadas
            int idDisciplina = Integer.parseInt(req.getParameter("idDisciplina"));

            listaProfessor = professorDAO.buscarPorDisciplina(idDisciplina);

            //coloca tuda a lista de professores( que é na verdade uma lista de jsons) em uma array no json
            professores.put("professores", listaProfessor);
            out.println(professores.toJson());

        } else if (tipo.equals("idProfessor")) {

            //pega o idProfessor
            int idProfessor = Integer.parseInt(req.getParameter("idProfessor"));
            listaProfessor = professorDAO.buscarPorIdProfessor(idProfessor);

            //coloca tuda a lista de professores( que é na verdade uma lista de jsons) em uma array no json
            professores.put("professores", listaProfessor);
            out.println(professores.toJson());

        }

        else if (tipo.equals("id")) {

            //pega o idProfessor
            String id = req.getParameter("_id");

            listaProfessor = professorDAO.buscarPorObId(id);

            //coloca tuda a lista de professores( que é na verdade uma lista de jsons) em uma array no json
            professores.put("professores", listaProfessor);
            out.println(professores.toJson());

        }
        else if (tipo.equals("email")) {

            String email = req.getParameter("email");

            listaProfessor = professorDAO.buscarPorEmail(email);
            System.out.println(listaProfessor);
            professores.put("professores", listaProfessor);
            out.println(professores.toJson());
        }
    }
}
