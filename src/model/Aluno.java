package model;

import java.time.LocalDate;

public class Aluno {
    private int id;
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String telefone;
    private String email;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Aluno() {
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public Aluno(int id, String cpf, String nome, LocalDate nascimento, String telefone, String email) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.email = email;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; atualizar(); }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; atualizar(); }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; atualizar(); }

    public LocalDate getNascimento() { return nascimento; }
    public void setNascimento(LocalDate nascimento) { this.nascimento = nascimento; atualizar(); }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; atualizar(); }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; atualizar(); }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public LocalDate getDataModificacao() { return dataModificacao; }

    private void atualizar() {
        this.dataModificacao = LocalDate.now();
    }
}
