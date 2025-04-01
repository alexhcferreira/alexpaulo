package dao;

import model.Pessoa;

public class PessoaDAO {

    private static final int MAX_PESSOAS = 100;
    private Pessoa[] pessoas = new Pessoa[MAX_PESSOAS];
    private int contador = 0;

    public boolean adicionar(Pessoa pessoa) {
        if (contador >= MAX_PESSOAS) {
            System.out.println("Limite de pessoas atingido!");
            return false;
        }
        pessoas[contador] = pessoa;
        contador++;
        return true;
    }

    public Pessoa buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (pessoas[i].getId() == id) {
                return pessoas[i];
            }
        }
        return null;
    }

    public Pessoa buscarPorLogin(String login) {
        for (int i = 0; i < contador; i++) {
            if (pessoas[i].getLogin().equalsIgnoreCase(login)) {
                return pessoas[i];
            }
        }
        return null;
    }

    public boolean atualizar(Pessoa atualizada) {
        for (int i = 0; i < contador; i++) {
            if (pessoas[i].getId() == atualizada.getId()) {
                pessoas[i] = atualizada;
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        for (int i = 0; i < contador; i++) {
            if (pessoas[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    pessoas[j] = pessoas[j + 1];
                }
                pessoas[--contador] = null;
                return true;
            }
        }
        return false;
    }

    public Pessoa[] listarTodos() {
        Pessoa[] lista = new Pessoa[contador];
        for (int i = 0; i < contador; i++) {
            lista[i] = pessoas[i];
        }
        return lista;
    }
}
