package model;

import java.time.LocalDate;

public class Turma {
    private int id;
    private String nome;
    private Curso curso;
    private Escola escola;
    private String periodo; // Ex: "2025-1"
    private String status;  // "ativo" ou "inativo"
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Turma() {
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public Turma(int id, String nome, Curso curso, Escola escola, String periodo, String status) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.escola = escola;
        this.periodo = periodo;
        this.status = status;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; atualizar(); }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; atualizar(); }

    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; atualizar(); }

    public Escola getEscola() { return escola; }
    public void setEscola(Escola escola) { this.escola = escola; atualizar(); }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; atualizar(); }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; atualizar(); }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public LocalDate getDataModificacao() { return dataModificacao; }

    private void atualizar() {
        this.dataModificacao = LocalDate.now();
    }
}
