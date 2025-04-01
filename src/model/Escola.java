package model;

import java.time.LocalDate;

public class Escola {
    private int id;
    private String nome;
    private String cidade;
    private String telefone;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Escola() {
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public Escola(int id, String nome, String cidade, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.telefone = telefone;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; atualizar(); }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; atualizar(); }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; atualizar(); }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; atualizar(); }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public LocalDate getDataModificacao() { return dataModificacao; }

    private void atualizar() {
        this.dataModificacao = LocalDate.now();
    }
}
