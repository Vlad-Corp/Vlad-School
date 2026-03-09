package controller.aluno;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/app/aluno/recuperar")
public class RecuperarAluno extends HttpServlet {

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
            Document dados = Document.parse(jsonString);
            String email = dados.getString("email");
            String codigoRecebido = dados.getString("codigo");

            Object[] dadosCodigo = EmailAluno.codigosPorEmail.get(email);

            if (dadosCodigo != null) {
                String codigoArmazenado = (String) dadosCodigo[0];
                long timestamp = (long) dadosCodigo[1];
                long agora = System.currentTimeMillis();

                if ((agora - timestamp) <= 300000 && codigoArmazenado.equals(codigoRecebido)) {
                    EmailAluno.codigosPorEmail.remove(email);
                    resposta.append("retorno", true)
                            .append("mensagem", "Código válido");
                } else {
                    resposta.append("retorno", false)
                            .append("erro", "Código inválido ou expirado");
                }
            } else {
                resposta.append("retorno", false)
                        .append("erro", "Código inválido ou expirado");
            }

        } catch (Exception e) {
            resposta.append("retorno", false)
                    .append("erro", "Erro ao processar requisição: " + e.getMessage());
        }

        out.println(resposta.toJson());
    }
}