/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho.Entidades;

import trabalho.TiposBasicos.*;

public class Bolao {

    private int id;
    private String aposta;
    private Data data;

    int getId() {
        return this.id;
    }

    String getAposta() {
        return this.aposta;
    }

    Data getData() {
        return this.data;
    }

    void setID(int id) throws IllegalArgumentException {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("idInvalido");
        }
    }

    void setAposta(String aposta) throws IllegalArgumentException {
        if (aposta.length() <= 45) {
            this.aposta = aposta;
        } else {
            throw new IllegalArgumentException("apostaImvalida");
        }

    }

    void setData(Data data) throws IllegalArgumentException {
        if (data != null) {
            this.data = data;
        } else {
            throw new IllegalArgumentException("dataInvalida");
        }
    }
}
