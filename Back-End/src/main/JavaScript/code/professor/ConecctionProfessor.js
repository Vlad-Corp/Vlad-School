import Professor from './Professor.js';

const url = 'http://localhost:8080/TrabalhoDSV2/';

async function criarProfessor(professor=Professor) {
    try {
        professor = professor.paraJson();

        //metodo que que envia e conecta no backend para criar um professor'
        const resposta = await fetch(`${url}/app/professor/criar`, {
            method: 'POST',
            headers: {
                //seta o tipo de conteudo para json, para o backend entender que é um json
                'Content-Type': 'application/json',
            },
            //transforma para string o json professor
            body: JSON.stringify(professor)
        });

        // Verificar se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        // Converter resposta para json
        const dadosResposta = await resposta.json();
        console.log('sucesso:', dadosResposta);


        //retorna os dados da resposta para o frontend
        return dadosResposta;

        //try e catch, igual o java
    } catch (e) {
        //mensagem de erro, como no front é menos comum n tem um tratamento completo
        console.error('erro ao enviar:', e);
    }

}


async function exibirProfessorPorNome(nome=String) {
    try {
        //constante do tipo de busca
        const tipo = "nome";
        //cria a url com os parametros, e usa fetch para fazer a requisição get
        const resposta = await fetch(`${url}app/professor/exibir?tipo=${tipo}&nome=${(nome)}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        });
        //verifica se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        //converte a resposta para json
        const dadosResposta = await resposta.json();
        //separa da resposta de sucesso para resposta de professor
        const professoresArray = dadosResposta.professores;


        if (Array.isArray(professoresArray)) {
            // lista para armazenar objetos professor
            const listaProfessores = [];
            //pega o lenght da respsota
            const length = professoresArray.length;
            //for de respostas
            for (let i = 0; i < length; i++) {

                //converte cada json da resposta para um objeto professor usando o metodo deJson da classe professor, e adiciona na lista de professors
                const professorJson = professoresArray[i];
                //converte para objeto
                const professorObj = Professor.deJson(professorJson);
                //coloca na lista
                listaProfessores.push(professorObj);

            }
            //retorna lista de retorna
            return listaProfessores;

        }
    } catch (e) {
        console.error('Erro ao buscar professor por nome:', e);
    }

}

async function exibirProfessorTodos() {
    try {
        //constante do tipo de busca
        const tipo = "listar";
        //cria a url com os parametros, e usa fetch para fazer a requisição get
        const resposta = await fetch(`${url}app/professor/exibir?tipo=${tipo}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        });
        //verifica se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        //converte a resposta para json
        const dadosResposta = await resposta.json();
        //separa da resposta de sucesso para resposta de professor
        const professoresArray = dadosResposta.professores;


        if (Array.isArray(professoresArray)) {
            // lista para armazenar objetos professor
            const listaProfessores = [];
            //pega o lenght da respsota
            const length = professoresArray.length;
            //for de respostas
            for (let i = 0; i < length; i++) {

                //converte cada json da resposta para um objeto professor usando o metodo deJson da classe professor, e adiciona na lista de professors
                const professorJson = professoresArray[i];
                //converte para objeto
                const professorObj = Professor.deJson(professorJson);
                //coloca na lista
                listaProfessores.push(professorObj);

            }
            //retorna lista de retorna
            return listaProfessores;

        }
    } catch (e) {
        console.error('Erro ao buscar professor por nome:', e);
    }

}


async function exibirProfessorPorDisciplina(disciplina=String) {
    try {
        //constante do tipo de busca
        const tipo = "disciplina";
        //cria a url com os parametros, e usa fetch para fazer a requisição get
        const resposta = await fetch(`${url}app/professor/exibir?tipo=${tipo}&idDisciplina=${(disciplina)}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        });
        //verifica se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        //converte a resposta para json
        const dadosResposta = await resposta.json();
        //separa da resposta de sucesso para resposta de professor
        const professoresArray = dadosResposta.professores;


        if (Array.isArray(professoresArray)) {
            // lista para armazenar objetos professor
            const listaProfessores = [];
            //pega o lenght da respsota
            const length = professoresArray.length;
            //for de respostas
            for (let i = 0; i < length; i++) {

                //converte cada json da resposta para um objeto professor usando o metodo deJson da classe professor, e adiciona na lista de professors
                const professorJson = professoresArray[i];
                //converte para objeto
                const professorObj = Professor.deJson(professorJson);
                //coloca na lista
                listaProfessores.push(professorObj);

            }
            //retorna lista de retorna
            return listaProfessores;

        }
    } catch (e) {
        console.error('Erro ao buscar professor por nome:', e);
    }

}


async function exibirProfessorPorIdProfessor(idProfessor) {
    try {
        //constante do tipo de busca
        const tipo = "idProfessor";
        //cria a url com os parametros, e usa fetch para fazer a requisição get
        const resposta = await fetch(`${url}app/professor/exibir?tipo=${tipo}&idProfessor=${(idProfessor)}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        });
        //verifica se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        //converte a resposta para json
        const dadosResposta = await resposta.json();
        //separa da resposta de sucesso para resposta de professor
        const professoresArray = dadosResposta.professores;


        if (Array.isArray(professoresArray)) {
            // lista para armazenar objetos professor
            const listaProfessores = [];
            //pega o lenght da respsota
            const length = professoresArray.length;
            //for de respostas
            for (let i = 0; i < length; i++) {

                //converte cada json da resposta para um objeto professor usando o metodo deJson da classe professor, e adiciona na lista de professors
                const professorJson = professoresArray[i];
                //converte para objeto
                const professorObj = Professor.deJson(professorJson);
                //coloca na lista
                listaProfessores.push(professorObj);

            }
            //retorna lista de retorna
            return listaProfessores;

        }
    } catch (e) {
        console.error('Erro ao buscar professor por nome:', e);
    }

}



async function exibirProfessorPorId(id=String) {
    try {
        //constante do tipo de busca
        const tipo = "id";
        //cria a url com os parametros, e usa fetch para fazer a requisição get
        const resposta = await fetch(`${url}app/professor/exibir?tipo=${tipo}&_id=${(id)}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        });
        //verifica se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        //converte a resposta para json
        const dadosResposta = await resposta.json();
        //separa da resposta de sucesso para resposta de professor
        const professoresArray = dadosResposta.professores;


        if (Array.isArray(professoresArray)) {
            // lista para armazenar objetos professor
            const listaProfessores = [];
            //pega o lenght da respsota
            const length = professoresArray.length;
            //for de respostas
            for (let i = 0; i < length; i++) {

                //converte cada json da resposta para um objeto professor usando o metodo deJson da classe professor, e adiciona na lista de professors
                const professorJson = professoresArray[i];
                //converte para objeto
                const professorObj = Professor.deJson(professorJson);
                //coloca na lista
                listaProfessores.push(professorObj);

            }
            //retorna lista de retorna
            return listaProfessores;

        }
    } catch (e) {
        console.error('Erro ao buscar professor por nome:', e);
    }

}




async function deletarProfessor(id=String) {
    try {
        //constante do tipo de busca

        //cria a url com os parametros, e usa fetch para fazer a requisição post
        const resposta = await fetch(`${url}app/professor/deletar?_id=${id}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            }
        });
        //verifica se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        //converte a resposta para json
        const dadosResposta = await resposta.json();
        //separa da resposta de sucesso para resposta de professor

        return dadosResposta;
    } catch (e) {
        console.error('Erro ao deletar professor por nome:', e);
    }

}



//no JS n tem tipagem, portanto usamos o = para dizer que os atributos da função só aceitam string e professor
async function atualizarProfessor(id=String, professor=Professor) {
    try {
        professor = professor.paraJson();

        //metodo que que envia e conecta no backend para atualizar um professor
        const resposta = await fetch(`${url}app/professor/atualizar?_id=${id}`, {
            method: 'POST',
            headers: {
                //seta o tipo de conteudo para json, para o backend entender que é um json
                'Content-Type': 'application/json',
            },
            //transforma para string o json professor
            body: JSON.stringify(professor)
        });

        // Verificar se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        // Converter resposta para json
        const dadosResposta = await resposta.json();
        console.log('sucesso:', dadosResposta);


        //retorna os dados da resposta para o frontend
        return dadosResposta;

        //try e catch, igual o java
    } catch (e) {
        //mensagem de erro, como no front é menos comum n tem um tratamento completo
        console.error('erro ao enviar:', e);
    }

}




async function logarProfessor(email=String, senha=String) {
    try {

        const login = {
            email: email,
            senha: senha
        }

        //metodo que que envia e conecta no backend para criar um professor
        const resposta = await fetch(`${url}app/professor/logar`, {
            method: 'POST',
            headers: {
                //seta o tipo de conteudo para json, para o backend entender que é um json
                'Content-Type': 'application/json',
            },
            //transforma para string o json professor
            body: JSON.stringify(login)
        });

        // Verificar se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        // Converter resposta para json
        const dadosResposta = await resposta.json();
        

        //retorna os dados da resposta para o frontend
        const retorno = dadosResposta.retorno;
        return retorno;
        
        //try e catch, igual o java
    } catch (e) {
        //mensagem de erro, como no front é menos comum n tem um tratamento completo
        console.error('erro ao enviar:', e);
    }
    
}


async function enviarEmailProfessor(email=String) {
    try {

        const login = {
            email: email
        }

        const resposta = await fetch(`${url}app/professor/email`, {
            method: 'POST',
            headers: {
                //seta o tipo de conteudo para json, para o backend entender que é um json
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(login)
        });

        // Verificar se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        // Converter resposta para json
        const dadosResposta = await resposta.json();
        

        //retorna os dados da resposta para o frontend
        const retorno = dadosResposta.retorno;
        return retorno; 
        
        //try e catch, igual o java
    } catch (e) {
        //mensagem de erro, como no front é menos comum n tem um tratamento completo
        console.error('erro ao enviar:', e);
    }
    
}


async function recuperarProfessor(email=String, cod=String) {
    try {

        const dados = {
            email: email,
            codigo: cod
        }

        const resposta = await fetch(`${url}app/professor/recuperar`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(dados)
        });

        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        const dadosResposta = await resposta.json();
        return dadosResposta;
        
    } catch (e) {
        console.error('erro ao enviar:', e);
    }
}


async function exibirProfessorPorEmail(email=String) {
    try {
        //constante do tipo de busca
        const tipo = "email";
        //cria a url com os parametros, e usa fetch para fazer a requisição get
        const resposta = await fetch(`${url}app/professor/exibir?tipo=${tipo}&email=${(email)}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        });
        //verifica se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        //converte a resposta para json
        const dadosResposta = await resposta.json();
        //separa da resposta de sucesso para resposta de professor
        const professoresArray = dadosResposta.professores;

        if(professoresArray !== undefined && professoresArray.length > 0){

            // lista para armazenar objetos professor
            const listaProfessores = [];
            //pega o lenght da respsota
            const length = professoresArray.length;
            //for de respostas
            for (let i = 0; i < length; i++) {

                //converte cada json da resposta para um objeto professor usando o metodo deJson da classe professor, e adiciona na lista de professors
                const professorJson = professoresArray[i];
                //converte para objeto
                const professorObj = Professor.deJson(professorJson);
                //coloca na lista
                listaProfessores.push(professorObj);

            }
            //retorna lista de retorna
            return listaProfessores;

        }
        else{
            return null;
        }
    } catch (e) {
        console.error('Erro ao buscar professor por nome:', e);
    }

}













export {criarProfessor, exibirProfessorPorNome, exibirProfessorPorDisciplina, exibirProfessorPorId, exibirProfessorPorIdProfessor, exibirProfessorTodos, deletarProfessor, atualizarProfessor, logarProfessor, enviarEmailProfessor, recuperarProfessor, exibirProfessorPorEmail};