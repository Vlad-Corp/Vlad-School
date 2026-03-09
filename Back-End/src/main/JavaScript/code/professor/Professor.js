import Usuario from "./Usuario.js";

class Professor extends Usuario {
    constructor(nome, nomeUsuario, senha, tipo, email, idProfessor, disciplinasLecionadas, id) {
        super(nome, nomeUsuario, senha, tipo, email, id);
        this.idProfessor = idProfessor;
        this.disciplinasLecionadas = disciplinasLecionadas;
    }

    getIdProfessor() {
        return this.idProfessor;
    }

    getDisciplinasLecionadas() {
        return this.disciplinasLecionadas;
    }

    setSenha(senha) {this.senha = senha;}


    paraJson() {
        try {
            const professorJson = {
                nome: super.getNome(),
                nome_usuario: super.getNomeUsuario(),
                senha: super.getSenha(),
                email: super.getEmail(),
                tipo: "professor",
                dados_professor: {
                    id_professor: this.idProfessor,
                    disciplinaLecionadas: this.disciplinasLecionadas
                }
            };
            return professorJson;
        } catch (e) {
            console.log(e);
            return null;
        }
    }

    static deJson(jsonDoc) {
        try {
            const id = jsonDoc._id ? (jsonDoc._id.$oid || jsonDoc._id) : null;
            const nome = jsonDoc.nome;
            const nomeUsuario = jsonDoc.nome_usuario;
            const senha = jsonDoc.senha;
            const email = jsonDoc.email;
            const tipo = jsonDoc.tipo;

            const dadosProfessor = jsonDoc.dados_professor;
            const idProfessor = dadosProfessor.id_professor;
            
            let disciplinasLecionadas = dadosProfessor.disciplinaLecionadas;
            if (!disciplinasLecionadas) {
                disciplinasLecionadas = [];
            }

            return new Professor(
                nome, nomeUsuario, senha, tipo, email,
                idProfessor, disciplinasLecionadas, id
            );
        } catch (e) {
            console.log(e);
            return null;
        }
    }

    toString() {
        return JSON.stringify({
            id: super.getId(),
            nome: super.getNome(),
            nomeUsuario: super.getNomeUsuario(),
            email: super.getEmail(),
            tipo: super.getTipo(),
            idProfessor: this.idProfessor,
            disciplinasLecionadas: this.disciplinasLecionadas || []
        }, null, 2);
    }
}

export default Professor;