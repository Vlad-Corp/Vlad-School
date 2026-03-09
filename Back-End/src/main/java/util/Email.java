package util;

import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;

public class Email {


    // Gera códido de 6 digitos para verificar
    public static String gerarCodigoSeisDigitos() {
        Random random = new Random();
        int codigo = 100000 + random.nextInt(900000); // Gera entre 100000 e 999999
        return String.valueOf(codigo);
    }



    // Método para enviar email com o código
    public static void enviarCodigoPorEmail(String emailDestino, String codigo) {
        // configs do gmail
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Credenciais (Senha app do gmail)
        Env env = new Env();

        final String seuEmail = env.getEmail();
        final String suaSenha = env.getSenha(); // Senha de app, não a senha normal

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(seuEmail, suaSenha);
            }
        });

        try {
            // Criar mensagem
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(seuEmail));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailDestino));

            // Assunto do email
            message.setSubject("Seu código de verificação");

            // Uso html oara formatar o email
            String corpoEmail = String.format(
                    "<html>" +
                            "<body style='font-family: Arial, sans-serif;'>" +
                            "<h2 style='color: #333;'>Código de Verificação</h2>" +
                            "<p>Seu código de 6 dígitos é:</p>" +
                            "<h1 style='color: #4CAF50; font-size: 32px; letter-spacing: 5px;'>%s</h1>" +
                            "<p>Este código expira em 10 minutos.</p>" +
                            "<p>Se você não solicitou este código, ignore este email.</p>" +
                            "</body>" +
                            "</html>",
                    codigo
            );

            message.setContent(corpoEmail, "text/html; charset=utf-8");

            // Enviar
            Transport.send(message);

        } catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        }
    }


    //exemplo
    public static void main(String[] args) {
        // Exemplo de uso
        String email = "julia.watanabe@institutojef.org.br";
        String codigo = gerarCodigoSeisDigitos();

        System.out.println("Código gerado: " + codigo);
        enviarCodigoPorEmail(email, codigo);
    }
}