

class Disciplinas {
    constructor(id,nome) {
        this.id = id
        this.nome = nome
    }

    getId(){
        return this.id
    }
    getNome(){
        return this.nome
    }
    paraJson(){
        try{
            const disciplinaJson = {
                id:this.id,
                nome:this.nome
            }

            return disciplinaJson;
        }catch(e){
            console.error("Erro ao converter para JSON:", e);
            return null;
        }
    }
    static deJson(jsonDoc=JSON){
        try{

            const id = jsonDoc.id
            const nome = jsonDoc.nome;

            const aluno =Disciplinas(
                id, nome
            );
            return aluno;



        }catch(e){
            console.error("Erro ao converter de JSON:", e);
            return null;
        }
    }

    toString() {
        return JSON.stringify({
            id:this.id,
            nome: this.nome
        }, null, 2)
    }
}