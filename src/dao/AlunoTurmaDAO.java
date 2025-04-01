package dao;

import model.AlunoTurma;

public class AlunoTurmaDAO {

    private static final int MAX = 200;
    private AlunoTurma[] vinculacoes = new AlunoTurma[MAX];
    private int contador = 0;

    public boolean adicionar(AlunoTurma at) {
        if (contador >= MAX) return false;
        vinculacoes[contador++] = at;
        return true;
    }

    public AlunoTurma buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (vinculacoes[i].getId() == id) return vinculacoes[i];
        }
        return null;
    }

    public boolean atualizar(AlunoTurma novo) {
        for (int i = 0; i < contador; i++) {
            if (vinculacoes[i].getId() == novo.getId()) {
                vinculacoes[i] = novo;
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        for (int i = 0; i < contador; i++) {
            if (vinculacoes[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    vinculacoes[j] = vinculacoes[j + 1];
                }
                vinculacoes[--contador] = null;
                return true;
            }
        }
        return false;
    }

    public AlunoTurma[] listarTodos() {
        AlunoTurma[] lista = new AlunoTurma[contador];
        for (int i = 0; i < contador; i++) lista[i] = vinculacoes[i];
        return lista;
    }
}
