package testes;
import dao.AlunosDAO;
import model.Aluno;
import model.Notas;
import model.Observacoes;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
public class TesteBusca {

    public static void main(String[] args) {
        AlunosDAO alunosDAO = new AlunosDAO();
        List<Notas> notas = new ArrayList<>();

        // Notas do Professor 1 (Matéria 1) - 2 períodos
        notas.add(new Notas(1, 1, 8.5, "2024.1")); // Período 1
        notas.add(new Notas(1, 1, 9.0, "2024.2")); // Período 2

        // Notas do Professor 2 (Matéria 2) - 2 períodos
        notas.add(new Notas(2, 2, 7.5, "2024.1")); // Período 1
        notas.add(new Notas(2, 2, 8.0, "2024.2")); // Período 2

        // Notas do Professor 3 (Matéria 3) - 2 períodos
        notas.add(new Notas(3, 3, 9.5, "2024.1")); // Período 1
        notas.add(new Notas(3, 3, 9.2, "2024.2")); // Período 2

        // Criar observações
        List<Observacoes> observacoes = new ArrayList<>();
        observacoes.add(new Observacoes(1, "2024-03-15",
                "Aluno participativo nas aulas, demonstra interesse."));
        observacoes.add(new Observacoes(2, "2024-06-20",
                "Precisa melhorar na entrega de trabalhos em grupo."));
        observacoes.add(new Observacoes(3, "2024-09-10",
                "Excelente desempenho no segundo período."));

        // Instanciar o aluno
        Aluno aluno = new Aluno(
                "João Silva",           // nome
                "joao.silva",           // nomeUsuario
                "senha123",             // senha
                "aluno",                // tipo
                "joao@escola.edu.br",   // email
                "20240001",             // matricula (String)
                "3º Ano EM",            // serie
                "aprovado",             // status
                notas,                  // lista de notas
                observacoes             // lista de observacoes
        );

        // Teste 1: criar aluno
        System.out.println(alunosDAO.criarAluno(aluno));
    }
}
