
import { exibirDisciplinaPorId } from '../disciplina/ConnectionDisciplina.js';
import NotasMostrar from './NotasMostrar.js';
import {  exibirAlunoPorId } from './ConecctionAluno.js';
import Disciplinas from '../disciplina/Disciplina.js';

// instanciando um dicionario com o idDisciplina e a sua respectiva disciplina
const discionarioDiscplina = {
    1:"Teoria da Conspiração",
    2:"Programação Orientada a Apostas",
    3:"Lavagem de Dinheiro",
    4:"Matemática",
    5:"Português",
    6:"História",
    7:"Ciêcias",
    8:"Informática"
}

// instanciando o dicionario que vai ficar as notas de cada materia
let dicionarioNotas = {
    "Teoria da Conspiração":null,
    "Programação Orientada a Apostas":null,
    "Lavagem de Dinheiro":null,
    "Matemática":null,
    "Português":null,
    "História":null,
    "Ciêcias":null,
    "Informática":null
}

console.log('ola')

// puxando os dados do aluno
const aluno = await exibirAlunoPorId("69977d14fb66d10cde847db4");

// colocando o nome do aluno na pagina
const nomePagina = document.querySelector('.asideHeader div p')
nomePagina.innerText = aluno[0].nome

// dando for em cada uma das nota daquele aluno
for (const nota of aluno[0].notas){

    // pegando o nome da disciplina de acordo com aquele dicionario
    const nomeDisciplina = discionarioDiscplina[nota.idDisciplina]

    // verificação de qual periodo é aquela nota
    if (nota.periodo === "2026.1"){

        if (dicionarioNotas[nomeDisciplina] != null){
            dicionarioNotas[nomeDisciplina].setNota1(nota.nota)
        } else {
            dicionarioNotas[nomeDisciplina] = new NotasMostrar(nota.nota,null)
        }

    } else if (nota.periodo === "2026.2"){

        if (dicionarioNotas[nomeDisciplina] != null){
            dicionarioNotas[nomeDisciplina].setNota2(nota.nota)
        } else {
            dicionarioNotas[nomeDisciplina] = new NotasMostrar(null,nota.nota)
        }
    }
}

const listaNotas = []

console.log('oi')

for (const nota of Object.values(dicionarioNotas) ){
    listaNotas.push(nota)
}

console.log(listaNotas)

const tabela = document.getElementsByTagName('table');

for (const [materia,nota] of Object.entries(dicionarioNotas)){

    const linha = document.createElement('tr')

    const tdMateria = document.createElement('td');
    const tdNota1 = document.createElement('td');
    const tdNota2 = document.createElement('td');
    const tdMedia = document.createElement('td');
    const tdSituacao = document.createElement('td');

    tdMateria.textContent = materia;

    if (nota == null){

        tdNota1.textContent = '--';
        tdNota2.textContent = '--';
        tdMedia.textContent = '--';
        tdSituacao.textContent = 'Em andamento';
        
    } else {

        if (nota.getNota2() == null) {

            tdNota1.textContent = nota.getNota1().toFixed(1);

            tdNota2.textContent = '--'; 

            tdMedia.textContent = nota.getNota1().toFixed(1)

            tdSituacao.textContent = 'Em andamento'

        } else if (nota.getNota1() == null) {

            tdNota2.textContent = nota.getNota2().toFixed(1)

            tdNota1.textContent = '--'; 

            tdMedia.textContent = nota.getNota2().toFixed(1)

            tdSituacao.textContent = 'Em andamento';

        } else {

            tdNota1.textContent = nota.getNota1().toFixed(1);

            tdNota2.textContent = nota.getNota2().toFixed(1); 

            tdMedia.textContent = (nota.getNota1() + nota.getNota2())/2 .toFixed(1); 

            if (tdMedia.textContent >= 7) {
                tdSituacao.textContent = 'Aprovado'
            } else {
                tdSituacao.textContent = 'Reprovado';
            }
        }

    }

    linha.appendChild(tdMateria);
    linha.appendChild(tdNota1);
    linha.appendChild(tdNota2);
    linha.appendChild(tdMedia);
    linha.appendChild(tdSituacao);

    tabela[0].appendChild(linha);
}

