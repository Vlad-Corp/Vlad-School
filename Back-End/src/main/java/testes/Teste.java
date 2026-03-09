package testes;
import conexao.Conectar;
import dao.AlunosDAO;
import dao.DisciplinaDAO;

public class Teste {
    public static void main(String[] args) throws InterruptedException {
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        System.out.println(disciplinaDAO.ultimoId());
    }
}
