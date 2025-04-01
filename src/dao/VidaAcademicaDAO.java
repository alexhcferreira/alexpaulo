package dao;

import model.VidaAcademica;

public class VidaAcademicaDAO {

    private static final int MAX = 100;
    private VidaAcademica[] registros = new VidaAcademica[MAX];
    private int contador = 0;

    public boolean adicionar(VidaAcademica v) {
        if (contador >= MAX) return false;
        registros[contador++] = v;
        return true;
    }

    public VidaAcademica buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (registros[i].getId() == id) return registros[i];
        }
        return null;
    }

    public boolean atualizar(VidaAcademica novo) {
        for (int i = 0; i < contador; i++) {
            if (registros[i].getId() == novo.getId()) {
                registros[i] = novo;
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

    public VidaAcademica[] listarTodos() {
        VidaAcademica[] lista = new VidaAcademica[contador];
        for (int i = 0; i < contador; i++) lista[i] = registros[i];
        return lista;
    }
}
