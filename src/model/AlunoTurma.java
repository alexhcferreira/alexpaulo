package model;

import java.time.LocalDate;

public class AlunoTurma {
    private int id;
    private Aluno aluno;
    private Turma turma;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public AlunoTurma() {
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public AlunoTurma(int id, Aluno aluno, Turma turma) {
        this.id = id;
        this.aluno = aluno;
        this.turma = turma;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; atualizar(); }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; atualizar(); }

    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; atualizar(); }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public LocalDate getDataModificacao() { return dataModificacao; }

    private void atualizar() {
        this.dataModificacao = LocalDate.now();
    }
}
