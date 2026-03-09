package controller.disciplina;

import jakarta.servlet.http.HttpServlet;
import dao.DisciplinaDAO;
import util.JsonLoader;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.Document;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

    @WebServlet("/app/disciplina/exibir")
public class ExibirDisciplina extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        //lista de alunos, todos os metodos de busca retornam isso
        List<Document> listaDisciplinas = new ArrayList<>();


        //muda de html para json
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // classe necessaria para escrever no http e mandar o json
        PrintWriter out = resp.getWriter();

        //carrega um json modelo
        Document modelo = JsonLoader.carregar("Jsons/modelJson.json");
        Document disciplinas = modelo;

        //pega qual tipo de busca a requisiçao quer
        String tipo =  req.getParameter("tipo");

        // verificações de de qual tipo de retorno que tem que voltar
        if (tipo == null){
            out.println(modelo);
        } else if (tipo.equals("id")) {

            // pegando o a disciplina que corresponde ao id procurado
            int id = Integer.parseInt(req.getParameter("id"));

            listaDisciplinas.add(disciplinaDAO.bucarPorId(id));
            disciplinas.put("disciplinas",listaDisciplinas);

            out.println(disciplinas.toJson());
        } else if (tipo.equals("todas")) {
            // retorna uma lista com todas as disciplinas cadstradas no banco

            listaDisciplinas = disciplinaDAO.listarDisciplinas();

            disciplinas.put("disciplinas",listaDisciplinas);
            out.println(disciplinas.toJson());
        } else if (tipo.equals("nome")) {

            // pegando a disciplina que tem aquele nome cadastrodo no banco

            String nome = req.getParameter("nome");

            listaDisciplinas.add(disciplinaDAO.bucarPorNome(nome));
            disciplinas.put("disciplinas",listaDisciplinas);
            out.println(disciplinas.toJson());

        }
        else if (tipo.equals("_id")) {

            String id = req.getParameter("_id");

            listaDisciplinas.add(disciplinaDAO.bucarPorObId(id));
            disciplinas.put("disciplinas",listaDisciplinas);
            out.println(disciplinas.toJson());

        }
    }
}
