package model;

public class Notas {
    private int idProfessor;
    private int idDisciplina;
    private double nota;
    private String periodo;

    public Notas(int idProfessor, int idDisciplina, double nota1, String periodo) {
        this.idProfessor = idProfessor;
        this.idDisciplina = idDisciplina;
        this.nota = nota1;
        this.periodo = periodo;
    }

    public int getIdProfessor() {
        return this.idProfessor;
    }

    public int getIdDisciplina() {
        return this.idDisciplina;
    }

    public double getNota() {
        return this.nota;
    }


    public String getPeriodo() {
        return this.periodo;
    }

    public void setNota(double nota1) {
        this.nota = nota1;
    }


    @Override
    public String toString() {
        return "{\n" +
                "  \"idProfessor\": " + idProfessor + ",\n" +
                "  \"idDisciplina\": " + idDisciplina + ",\n" +
                "  \"nota\": " + nota + ",\n" +
                "  \"periodo\": \"" + periodo + "\"\n" +
                "}";
    }
}
