package model;

import java.time.LocalDate;

public class RegistroProfessor {
    private int id;
    private Pessoa professor;
    private String disciplina;
    private String periodo; // 1º TRIMESTRE, 2º BIMESTRE, etc.
    private Turma turma;
    private String revisaoGeralTurma;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public RegistroProfessor() {
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public RegistroProfessor(int id, Pessoa professor, String disciplina, String periodo, Turma turma, String revisaoGeralTurma) {
        this.id = id;
        this.professor = professor;
        this.disciplina = disciplina;
        this.periodo = periodo;
        this.turma = turma;
        this.revisaoGeralTurma = revisaoGeralTurma;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; atualizar(); }

    public Pessoa getProfessor() { return professor; }
    public void setProfessor(Pessoa professor) { this.professor = professor; atualizar(); }

    public String getDisciplina() { return disciplina; }
    public void setDisciplina(String disciplina) { this.disciplina = disciplina; atualizar(); }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; atualizar(); }

    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; atualizar(); }

    public String getRevisaoGeralTurma() { return revisaoGeralTurma; }
    public void setRevisaoGeralTurma(String revisaoGeralTurma) { this.revisaoGeralTurma = revisaoGeralTurma; atualizar(); }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public LocalDate getDataModificacao() { return dataModificacao; }

    private void atualizar() {
        this.dataModificacao = LocalDate.now();
    }
}
