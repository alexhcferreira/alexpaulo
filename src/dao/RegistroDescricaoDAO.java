package dao;

import model.RegistroDescricao;

public class RegistroDescricaoDAO {

    private static final int MAX = 300;
    private RegistroDescricao[] descricoes = new RegistroDescricao[MAX];
    private int contador = 0;

    public boolean adicionar(RegistroDescricao r) {
        if (contador >= MAX) return false;
        descricoes[contador++] = r;
        return true;
    }

    public RegistroDescricao buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (descricoes[i].getId() == id) return descricoes[i];
        }
        return null;
    }

    public boolean atualizar(RegistroDescricao r) {
        for (int i = 0; i < contador; i++) {
            if (descricoes[i].getId() == r.getId()) {
                descricoes[i] = r;
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        for (int i = 0; i < contador; i++) {
            if (descricoes[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    descricoes[j] = descricoes[j + 1];
                }
                descricoes[--contador] = null;
                return true;
            }
        }
        return false;
    }

    public RegistroDescricao[] listarTodos() {
        RegistroDescricao[] lista = new RegistroDescricao[contador];
        for (int i = 0; i < contador; i++) lista[i] = descricoes[i];
        return lista;
    }
}
