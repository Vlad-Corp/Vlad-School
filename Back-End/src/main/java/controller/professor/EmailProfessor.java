package controller.professor;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.Document;
import util.Email;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/app/professor/email")
public class EmailProfessor extends HttpServlet {

    protected static Map<String, Object[]> codigosPorEmail = new HashMap<>();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        Document resposta = new Document();

        try {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            try (BufferedReader reader = req.getReader()) {
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
            }

            String jsonString = jsonBuilder.toString();
            String email = Document.parse(jsonString).getString("email");

            String codigo = Email.gerarCodigoSeisDigitos();
            codigosPorEmail.put(email, new Object[]{codigo, System.currentTimeMillis()});

            Email.enviarCodigoPorEmail(email, codigo);

            resposta.append("sucesso", true)
                    .append("mensagem", "Código enviado com sucesso");

        } catch (Exception e) {
            resposta.append("sucesso", false)
                    .append("erro", "Erro ao processar requisição: " + e.getMessage());
        }

        out.println(resposta.toJson());
    }
}