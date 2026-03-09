

//TUDO AQUI É FEITO POR IA, USE APENAS PARA TESTES!!, nÃO USAR ESSES DADOS NO PROJETO REAL!!


// teste_completo.js
import { 
    criarProfessor, 
    exibirProfessorPorNome, 
    exibirProfessorPorDisciplina, 
    exibirProfessorPorId, 
    exibirProfessorPorIdProfessor, 
    exibirProfessorTodos, 
    deletarProfessor, 
    atualizarProfessor, 
    logarProfessor 
} from './ConecctionProfessor.js';
import Professor from './Professor.js';

// Função para testar a busca por nome (usando o professor que você forneceu)
async function testarBuscaPorNome() {
    console.log("=== TESTE 1: Buscar professor por nome 'Ana Souza' ===");
    try {
        const professores = await exibirProfessorPorNome("Ana Souza");
        if (professores && professores.length > 0) {
            console.log("Professores encontrados:");
            professores.forEach((prof, index) => {
                console.log(`\nProfessor ${index + 1}:`);
                console.log(prof.toString());
            });
        } else {
            console.log("Nenhum professor encontrado com esse nome.");
        }
    } catch (error) {
        console.error("Erro no teste de busca por nome:", error);
    }
}

// Testar busca por ID do MongoDB
async function testarBuscaPorId() {
    console.log("\n=== TESTE 2: Buscar professor por ID do MongoDB ===");
    try {
        const id = "69977251c062ef53ea6da2a7"; // ID do professor que você forneceu
        const professores = await exibirProfessorPorId(id);
        if (professores && professores.length > 0) {
            console.log("Professor encontrado por ID:");
            console.log(professores[0].toString());
        } else {
            console.log("Nenhum professor encontrado com esse ID.");
        }
    } catch (error) {
        console.error("Erro no teste de busca por ID:", error);
    }
}

// Testar busca por ID do Professor
async function testarBuscaPorIdProfessor() {
    console.log("\n=== TESTE 3: Buscar professor por ID do Professor (id_professor=1) ===");
    try {
        const idProfessor = 1;
        const professores = await exibirProfessorPorIdProfessor(idProfessor);
        if (professores && professores.length > 0) {
            console.log("Professores encontrados por ID do Professor:");
            professores.forEach((prof, index) => {
                console.log(`\nProfessor ${index + 1}:`);
                console.log(prof.toString());
            });
        } else {
            console.log("Nenhum professor encontrado com esse ID de professor.");
        }
    } catch (error) {
        console.error("Erro no teste de busca por ID do Professor:", error);
    }
}

// Testar busca por disciplina
async function testarBuscaPorDisciplina() {
    console.log("\n=== TESTE 4: Buscar professor por disciplina (id=4) ===");
    try {
        const idDisciplina = 4;
        const professores = await exibirProfessorPorDisciplina(idDisciplina);
        if (professores && professores.length > 0) {
            console.log(`Professores que lecionam a disciplina ${idDisciplina}:`);
            professores.forEach((prof, index) => {
                console.log(`\nProfessor ${index + 1}:`);
                console.log(prof.toString());
            });
        } else {
            console.log("Nenhum professor encontrado para essa disciplina.");
        }
    } catch (error) {
        console.error("Erro no teste de busca por disciplina:", error);
    }
}

// Testar buscar todos os professores
async function testarBuscarTodos() {
    console.log("\n=== TESTE 5: Buscar todos os professores ===");
    try {
        const professores = await exibirProfessorTodos();
        if (professores && professores.length > 0) {
            console.log(`Total de professores encontrados: ${professores.length}`);
            professores.forEach((prof, index) => {
                console.log(`\nProfessor ${index + 1}:`);
                console.log(`Nome: ${prof.getNome()}`);
                console.log(`Email: ${prof.getEmail()}`);
                console.log(`ID Professor: ${prof.getIdProfessor()}`);
                console.log(`Disciplinas: ${prof.getDisciplinasLecionadas().join(', ')}`);
            });
        } else {
            console.log("Nenhum professor encontrado.");
        }
    } catch (error) {
        console.error("Erro no teste de buscar todos:", error);
    }
}

// Testar criação de um novo professor
async function testarCriarProfessor() {
    console.log("\n=== TESTE 6: Criar um novo professor ===");
    try {
        // Criando um novo professor baseado no modelo que você forneceu
        const novoProfessor = new Professor(
            "Carlos Santos",           // nome
            "carlos.mat",               // nomeUsuario
            "senha123",                  // senha
            "professor",                 // tipo
            "carlos.santos@email.com",   // email
            2,                            // idProfessor
            [1, 3],                       // disciplinasLecionadas
            null                          // id (será gerado pelo banco)
        );

        console.log("Enviando professor para criação:");
        console.log(novoProfessor.toString());
        
        const resultado = await criarProfessor(novoProfessor);
        console.log("Resultado da criação:", resultado);
        
        return resultado; // Retornar para possível uso em outros testes
    } catch (error) {
        console.error("Erro no teste de criação:", error);
    }
}

// Testar atualização de professor
async function testarAtualizarProfessor() {
    console.log("\n=== TESTE 7: Atualizar professor ===");
    try {
        const id = "69977251c062ef53ea6da2a7"; // ID do professor a ser atualizado
        
        // Buscar o professor primeiro para garantir que ele existe
        const professores = await exibirProfessorPorId(id);
        if (!professores || professores.length === 0) {
            console.log("Professor não encontrado para atualização.");
            return;
        }
        
        const professorExistente = professores[0];
        console.log("Professor antes da atualização:");
        console.log(professorExistente.toString());
        
        // Modificar alguns dados
        professorExistente.nome = "Ana Souza Silva";
        professorExistente.disciplinasLecionadas = [4, 5]; // Adicionando nova disciplina
        
        const resultado = await atualizarProfessor(id, professorExistente);
        console.log("Resultado da atualização:", resultado);
        
        // Verificar se a atualização funcionou
        const professoresAtualizados = await exibirProfessorPorId(id);
        if (professoresAtualizados && professoresAtualizados.length > 0) {
            console.log("\nProfessor após atualização:");
            console.log(professoresAtualizados[0].toString());
        }
    } catch (error) {
        console.error("Erro no teste de atualização:", error);
    }
}

// Testar login
async function testarLogin() {
    console.log("\n=== TESTE 8: Testar login ===");
    try {
        // Usando as credenciais do professor que você forneceu
        const email = "ana.souza@outlook.com.br";
        const senha = "123456";
        
        console.log(`Tentando login com email: ${email}`);
        const resultado = await logarProfessor(email, senha);
        
        if (resultado) {
            console.log("Login bem-sucedido!");
            console.log("Resultado:", resultado);
        } else {
            console.log("Falha no login.");
        }
    } catch (error) {
        console.error("Erro no teste de login:", error);
    }
}

// Testar deletar professor (use com cuidado!)
async function testarDeletarProfessor() {
    console.log("\n=== TESTE 9: Deletar professor (COMENTADO POR SEGURANÇA) ===");
    /*
    try {
        const id = "69977251c062ef53ea6da2a7"; // ID do professor a ser deletado
        console.log(`Tentando deletar professor com ID: ${id}`);
        
        const resultado = await deletarProfessor(id);
        console.log("Resultado da deleção:", resultado);
    } catch (error) {
        console.error("Erro no teste de deleção:", error);
    }
    */
    console.log("Teste de deleção comentado por segurança. Descomente se necessário.");
}

// Função principal para executar todos os testes
async function executarTodosTestes() {
    console.log("INICIANDO TESTES DA CONEXÃO COM O BANCO DE DADOS\n");
    console.log("=".repeat(50));
    
    // Testes de leitura (seguros)
    await testarBuscaPorNome();
    console.log("\n" + "=".repeat(50));
    
    await testarBuscaPorId();
    console.log("\n" + "=".repeat(50));
    
    await testarBuscaPorIdProfessor();
    console.log("\n" + "=".repeat(50));
    
    await testarBuscaPorDisciplina();
    console.log("\n" + "=".repeat(50));
    
    await testarBuscarTodos();
    console.log("\n" + "=".repeat(50));
    
    // Testes de login
    await testarLogin();
    console.log("\n" + "=".repeat(50));
    
    // Testes de escrita (use com cuidado, podem modificar o banco)
    console.log("\nAVISO: Os próximos testes podem modificar o banco de dados!");
    console.log("Deseja continuar com os testes de escrita? (pressione Ctrl+C para cancelar)");
    console.log("Continuando em 3 segundos...\n");
    
    // Pequena pausa para leitura
    await new Promise(resolve => setTimeout(resolve, 3000));
    
    await testarCriarProfessor();
    console.log("\n" + "=".repeat(50));
    
    await testarAtualizarProfessor();
    console.log("\n" + "=".repeat(50));
    
    await testarDeletarProfessor();
    
    console.log("\n" + "=".repeat(50));
    console.log("TESTES FINALIZADOS");
}

// Teste específico apenas para o professor que você forneceu
async function testarProfessorEspecifico() {
    console.log("TESTANDO APENAS O PROFESSOR ESPECÍFICO\n");
    
    const professores = await exibirProfessorPorNome("Ana Souza");
    if (professores && professores.length > 0) {
        const professor = professores[0];
        console.log("Professor encontrado:");
        console.log(`Nome: ${professor.getNome()}`);
        console.log(`Email: ${professor.getEmail()}`);
        console.log(`ID Professor: ${professor.getIdProfessor()}`);
        console.log(`Disciplinas: ${professor.getDisciplinasLecionadas().join(', ')}`);
        console.log(`ID MongoDB: ${professor.getId()}`);
        
        // Testar busca por ID do MongoDB
        if (professor.getId()) {
            console.log("\nTestando busca por ID do MongoDB...");
            const professoresPorId = await exibirProfessorPorId(professor.getId());
            if (professoresPorId && professoresPorId.length > 0) {
                console.log("Busca por ID funcionou!");
            }
        }
        
        // Testar busca por ID do Professor
        console.log("\nTestando busca por ID do Professor...");
        const professoresPorIdProf = await exibirProfessorPorIdProfessor(professor.getIdProfessor());
        if (professoresPorIdProf && professoresPorIdProf.length > 0) {
            console.log("Busca por ID do Professor funcionou!");
        }
        
        // Testar busca por disciplina
        const disciplinas = professor.getDisciplinasLecionadas();
        if (disciplinas && disciplinas.length > 0) {
            console.log(`\nTestando busca pela disciplina ${disciplinas[0]}...`);
            const professoresPorDisciplina = await exibirProfessorPorDisciplina(disciplinas[0]);
            if (professoresPorDisciplina && professoresPorDisciplina.length > 0) {
                console.log("Busca por disciplina funcionou!");
            }
        }
    } else {
        console.log("Professor 'Ana Souza' não encontrado!");
    }
}

// Escolha qual teste executar:

// Opção 1: Executar testes específicos para o professor que você forneceu
console.log("Executando teste específico para o professor Ana Souza...");
await executarTodosTestes();

// Opção 2: Executar todos os testes (descomente a linha abaixo)
// await executarTodosTestes();

// Opção 3: Executar um teste específico (descomente a linha desejada)
// await testarBuscaPorNome();
// await testarBuscaPorId();
// await testarLogin();
// await testarCriarProfessor();