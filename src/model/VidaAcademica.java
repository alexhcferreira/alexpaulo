package model;

import java.time.LocalDate;

public class VidaAcademica {
    private int id;
    private String tipo; // observação, evento, incidente, advertência, mérito
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public VidaAcademica() {
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public VidaAcademica(int id, String tipo, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; atualizar(); }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; atualizar(); }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; atualizar(); }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public LocalDate getDataModificacao() { return dataModificacao; }

    private void atualizar() {
        this.dataModificacao = LocalDate.now();
    }
}
