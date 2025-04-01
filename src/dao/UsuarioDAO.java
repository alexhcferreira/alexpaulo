package dao;

import model.Usuario;

public class UsuarioDAO {

    private static final int MAX = 100;
    private Usuario[] usuarios = new Usuario[MAX];
    private int contador = 0;

    public boolean adicionar(Usuario usuario) {
        if (contador >= MAX) return false;
        usuarios[contador++] = usuario;
        return true;
    }

    public Usuario buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getId() == id) return usuarios[i];
        }
        return null;
    }

    public Usuario[] buscarPorPessoaId(int pessoaId) {
        int count = 0;
        Usuario[] temp = new Usuario[MAX];

        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getPessoa().getId() == pessoaId) {
                temp[count++] = usuarios[i];
            }
        }

        Usuario[] resultado = new Usuario[count];
        for (int i = 0; i < count; i++) {
            resultado[i] = temp[i];
        }
        return resultado;
    }

    public boolean atualizar(Usuario u) {
        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getId() == u.getId()) {
                usuarios[i] = u;
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    usuarios[j] = usuarios[j + 1];
                }
                usuarios[--contador] = null;
                return true;
            }
        }
        return false;
    }

    public Usuario[] listarTodos() {
        Usuario[] lista = new Usuario[contador];
        for (int i = 0; i < contador; i++) lista[i] = usuarios[i];
        return lista;
    }
}
