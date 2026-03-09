package controller.adm;

import dao.AdmDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.Document;
import util.JsonLoader;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;
import java.util.List;

    @WebServlet("/app/adm/exibir")
public class ExibirAdm extends HttpServlet {
    AdmDAO admDAO = new AdmDAO();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {


        //lista de alunos, todos os metodos de busca retornam isso
        List<Document> listaAdms;


        //muda de html para json
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // classe necessaria para escrever no http e mandar o json
        PrintWriter out = resp.getWriter();

        //carrega um json modelo
        Document modelo = JsonLoader.carregar("Jsons/modelJson.json");
        Document adms = modelo;

        //pega qual tipo de busca a requisiçao quer
        String tipo =  req.getParameter("tipo");


        //compara as buscas
        if (tipo==null){
            out.println(modelo.toJson());
        } else if (tipo.equals("email")) {


            //busca por email
            String email = req.getParameter("email");

            System.out.println(email);

            //pesquisa no banco
            listaAdms = admDAO.buscarPorEmail(email);

            System.out.println(listaAdms);



            //coloca tuda a lista de alunos( que é na verdade uma lista de jsons) em uma array no json
            adms.put("adms", listaAdms);
            out.println(adms.toJson());

        }
    }
}
