package dao;

import model.RegistroProfessor;

public class RegistroProfessorDAO {

    private static final int MAX = 100;
    private RegistroProfessor[] registros = new RegistroProfessor[MAX];
    private int contador = 0;

    public boolean adicionar(RegistroProfessor r) {
        if (contador >= MAX) return false;
        registros[contador++] = r;
        return true;
    }

    public RegistroProfessor buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (registros[i].getId() == id) return registros[i];
        }
        return null;
    }

    public boolean atualizar(RegistroProfessor r) {
        for (int i = 0; i < contador; i++) {
            if (registros[i].getId() == r.getId()) {
                registros[i] = r;
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        for (int i = 0; i < contador; i++) {
            if (registros[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    registros[j] = registros[j + 1];
                }
                registros[--contador] = null;
                return true;
            }
        }
        return false;
    }

    public RegistroProfessor[] listarTodos() {
        RegistroProfessor[] lista = new RegistroProfessor[contador];
        for (int i = 0; i < contador; i++) lista[i] = registros[i];
        return lista;
    }
}
