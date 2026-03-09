package controller.aluno;

import dao.AlunosDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.Document;
import util.JsonLoader;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/app/aluno/exibir")

public class ExibirAluno extends HttpServlet {
    AlunosDAO alunosDAO = new AlunosDAO();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {


        //lista de alunos, todos os metodos de busca retornam isso
        List<Document> listaAlunos;


        //muda de html para json
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // classe necessaria para escrever no http e mandar o json
        PrintWriter out = resp.getWriter();

        //carrega um json modelo
        Document modelo = JsonLoader.carregar("Jsons/modelJson.json");
        Document alunos = modelo;

        //pega qual tipo de busca a requisiçao quer
        String tipo =  req.getParameter("tipo");


        //compara as buscas
        if (tipo==null){
            out.println(modelo.toJson());
        } else if (tipo.equals("id")) {


            //busca por id
            String id = req.getParameter("id");

            //pesquisa no banco
            listaAlunos = alunosDAO.buscarPorId(id);

            //coloca tuda a lista de alunos( que é na verdade uma lista de jsons) em uma array no json
            alunos.put("alunos", listaAlunos);
            out.println(alunos.toJson());

        } else if (tipo.equals("index")) {

            //indice das paginas da busca (10 em 10 resultados)
            int index = Integer.parseInt(req.getParameter("indice"));

            //pesquisa no banco
            listaAlunos = alunosDAO.buscarPorIndex(index);

            //coloca tuda a lista de alunos( que é na verdade uma lista de jsons) em uma array no json
            alunos.put("alunos", listaAlunos);
            out.println(alunos.toJson());
        } else if (tipo.equals("nome")) {

            //pega na requisição o nome do aluno
            String nome = req.getParameter("nome");

            //busca na dao, o nome similar to
            listaAlunos = alunosDAO.buscarPorNome(nome);

            //coloca tuda a lista de alunos( que é na verdade uma lista de jsons) em uma array no json
            alunos.put("alunos", listaAlunos);
            out.println(alunos.toJson());

        } else if (tipo.equals("serie")) {

            //pega na requisição o nome do aluno
            String serie = req.getParameter("serie");

            //busca na dao, a serie do aluno
            listaAlunos = alunosDAO.buscarPorSerie(serie);

            //coloca tuda a lista de alunos( que é na verdade uma lista de jsons) em uma array no json
            alunos.put("alunos", listaAlunos);
            out.println(alunos.toJson());
        } else if (tipo.equals("status")) {

            //pega na requisição o nome do aluno
            String status = req.getParameter("status");

            //busca na dao, os alunos com o status deles (aprovado, reprovado)
            listaAlunos = alunosDAO.buscarPorStatus(status);

            //coloca tuda a lista de alunos( que é na verdade uma lista de jsons) em uma array no json
            alunos.put("alunos", listaAlunos);
            out.println(alunos.toJson());
        } else if (tipo.equals("email")) {

            String email = req.getParameter("email");

            listaAlunos = alunosDAO.buscarPorEmail(email);

            alunos.put("alunos", listaAlunos);
            out.println(alunos.toJson());
        }
    }

}
