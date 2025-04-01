package model;

import java.time.LocalDate;

public class Usuario {
    private int id;
    private Pessoa pessoa;
    private Escola escola;
    private String tipo; // adm_geral, adm_escola, funcionario, professor
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Usuario() {
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public Usuario(int id, Pessoa pessoa, Escola escola, String tipo) {
        this.id = id;
        this.pessoa = pessoa;
        this.escola = escola;
        this.tipo = tipo;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; atualizar(); }

    public Pessoa getPessoa() { return pessoa; }
    public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; atualizar(); }

    public Escola getEscola() { return escola; }
    public void setEscola(Escola escola) { this.escola = escola; atualizar(); }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; atualizar(); }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public LocalDate getDataModificacao() { return dataModificacao; }

    private void atualizar() {
        this.dataModificacao = LocalDate.now();
    }
}
