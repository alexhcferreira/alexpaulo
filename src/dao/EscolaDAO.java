package dao;

import model.Escola;

public class EscolaDAO {

    private static final int MAX = 100;
    private Escola[] escolas = new Escola[MAX];
    private int contador = 0;

    public boolean adicionar(Escola escola) {
        if (contador >= MAX) return false;
        escolas[contador++] = escola;
        return true;
    }

    public Escola buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (escolas[i].getId() == id) return escolas[i];
        }
        return null;
    }

    public boolean atualizar(Escola e) {
        for (int i = 0; i < contador; i++) {
            if (escolas[i].getId() == e.getId()) {
                escolas[i] = e;
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        for (int i = 0; i < contador; i++) {
            if (escolas[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    escolas[j] = escolas[j + 1];
                }
                escolas[--contador] = null;
                return true;
            }
        }
        return false;
    }

    public Escola[] listarTodos() {
        Escola[] lista = new Escola[contador];
        for (int i = 0; i < contador; i++) lista[i] = escolas[i];
        return lista;
    }
}
