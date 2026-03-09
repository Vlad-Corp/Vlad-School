package util;

import org.bson.Document;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class JsonLoader {

    public static Document carregar(String nomeArquivo) {
        try (InputStream is = JsonLoader.class.getClassLoader()
                .getResourceAsStream(nomeArquivo)) {

            if (is == null) {
                throw new FileNotFoundException("arquivo não encontrado!");
            }

            // Lê tudo
            String conteudo = new String(is.readAllBytes());
            return Document.parse(conteudo);

        } catch (Exception e) {
           ExceptionHandler eh = new ExceptionHandler(e);
           eh.printExeption();
        }
        return null;
    }
}
