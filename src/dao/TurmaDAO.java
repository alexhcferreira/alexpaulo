package dao;

import model.Turma;

public class TurmaDAO {

    private static final int MAX = 100;
    private Turma[] turmas = new Turma[MAX];
    private int contador = 0;

    public boolean adicionar(Turma turma) {
        if (contador >= MAX) return false;
        turmas[contador++] = turma;
        return true;
    }

    public Turma buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (turmas[i].getId() == id) return turmas[i];
        }
        return null;
    }

    public boolean atualizar(Turma t) {
        for (int i = 0; i < contador; i++) {
            if (turmas[i].getId() == t.getId()) {
                turmas[i] = t;
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        for (int i = 0; i < contador; i++) {
            if (turmas[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    turmas[j] = turmas[j + 1];
                }
                turmas[--contador] = null;
                return true;
            }
        }
        return false;
    }

    public Turma[] listarTodos() {
        Turma[] lista = new Turma[contador];
        for (int i = 0; i < contador; i++) lista[i] = turmas[i];
        return lista;
    }
}
