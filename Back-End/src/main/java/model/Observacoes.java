package model;


public class Observacoes {
    private int idProfessor;
    private String data;
    private String observacao;
    public Observacoes(int idProfessor,String data, String observacao){
        this.idProfessor=idProfessor;
        this.data=data;
        this.observacao=observacao;
    }
    public int getIdProfessor(){
        return this.idProfessor;
    }
    public String getData(){
        return this.data;
    }
    public String getObservacao(){
        return this.observacao;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"idProfessor\": " + idProfessor + ",\n" +
                "  \"data\": \"" + data + "\",\n" +
                "  \"observacao\": \"" + observacao.replace("\"", "\\\"") + "\"\n" +
                "}";
    }
}
