package model;

import java.time.LocalDate;

public class Curso {
    private int id;
    private String nome;
    private String sigla;
    private String tipo; // superior, integrado, concomitante, etc.
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Curso() {
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public Curso(int id, String nome, String sigla, String tipo) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.tipo = tipo;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; atualizar(); }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; atualizar(); }

    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; atualizar(); }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; atualizar(); }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public LocalDate getDataModificacao() { return dataModificacao; }

    private void atualizar() {
        this.dataModificacao = LocalDate.now();
    }
}
