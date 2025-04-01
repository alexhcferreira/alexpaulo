package model;

import java.time.LocalDate;

public class RegistroDescricao {
    private int id;
    private RegistroProfessor registro;
    private Aluno aluno;
    private String observacao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public RegistroDescricao() {
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public RegistroDescricao(int id, RegistroProfessor registro, Aluno aluno, String observacao) {
        this.id = id;
        this.registro = registro;
        this.aluno = aluno;
        this.observacao = observacao;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; atualizar(); }

    public RegistroProfessor getRegistro() { return registro; }
    public void setRegistro(RegistroProfessor registro) { this.registro = registro; atualizar(); }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; atualizar(); }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; atualizar(); }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public LocalDate getDataModificacao() { return dataModificacao; }

    private void atualizar() {
        this.dataModificacao = LocalDate.now();
    }
}
