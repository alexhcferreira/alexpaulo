package model;

import java.time.LocalDate;

public class Pessoa {
    private int id;
    private static int serial = 1;
    private String nome;
    private LocalDate nascimento;
    private String telefone;
    private String login;
    private String senha;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Pessoa() {
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public Pessoa(String nome, LocalDate nascimento, String telefone, String login, String senha) {
        this.id = serial;
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
        serial++;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; atualizarModificacao(); }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; atualizarModificacao(); }

    public LocalDate getNascimento() { return nascimento; }
    public void setNascimento(LocalDate nascimento) { this.nascimento = nascimento; atualizarModificacao(); }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; atualizarModificacao(); }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; atualizarModificacao(); }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; atualizarModificacao(); }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public LocalDate getDataModificacao() { return dataModificacao; }

    private void atualizarModificacao() {
        this.dataModificacao = LocalDate.now();
    }
}
