import { recuperarAdm } from '../adm/ConnectionAdm.js';
import { exibirAlunoPorEmail, exibirAlunoPorId } from '../aluno/ConecctionAluno.js';
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


console.log(await recuperarAdm("aisfjpewi"));