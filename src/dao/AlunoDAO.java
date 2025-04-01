package dao;

import model.Aluno;

public class AlunoDAO {

    private static final int MAX = 100;
    private Aluno[] alunos = new Aluno[MAX];
    private int contador = 0;

    public boolean adicionar(Aluno aluno) {
        if (contador >= MAX) return false;
        alunos[contador++] = aluno;
        return true;
    }

    public Aluno buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (alunos[i].getId() == id) return alunos[i];
        }
        return null;
    }

    public boolean atualizar(Aluno a) {
        for (int i = 0; i < contador; i++) {
            if (alunos[i].getId() == a.getId()) {
                alunos[i] = a;
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        for (int i = 0; i < contador; i++) {
            if (alunos[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    alunos[j] = alunos[j + 1];
                }
                alunos[--contador] = null;
                return true;
            }
        }
        return false;
    }

    public Aluno[] listarTodos() {
        Aluno[] lista = new Aluno[contador];
        for (int i = 0; i < contador; i++) lista[i] = alunos[i];
        return lista;
    }
}
