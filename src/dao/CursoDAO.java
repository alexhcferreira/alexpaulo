package dao;

import model.Curso;

public class CursoDAO {

    private static final int MAX = 100;
    private Curso[] cursos = new Curso[MAX];
    private int contador = 0;

    public boolean adicionar(Curso curso) {
        if (contador >= MAX) return false;
        cursos[contador++] = curso;
        return true;
    }

    public Curso buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (cursos[i].getId() == id) return cursos[i];
        }
        return null;
    }

    public boolean atualizar(Curso c) {
        for (int i = 0; i < contador; i++) {
            if (cursos[i].getId() == c.getId()) {
                cursos[i] = c;
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        for (int i = 0; i < contador; i++) {
            if (cursos[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    cursos[j] = cursos[j + 1];
                }
                cursos[--contador] = null;
                return true;
            }
        }
        return false;
    }

    public Curso[] listarTodos() {
        Curso[] lista = new Curso[contador];
        for (int i = 0; i < contador; i++) lista[i] = cursos[i];
        return lista;
    }
}
