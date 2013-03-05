/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho.Entidades;

import trabalho.TiposBasicos.*;

public class Bolao {

    private int id;
    private String aposta;
    private String data;

    int getId() {
        return this.id;
    }

    String getAposta() {
        return this.aposta;
    }

    String getData() {
        return this.data;
    }

    void setId(int id) throws IllegalArgumentException {
        if (id >= 0) {
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

    void setData(String data) throws IllegalArgumentException {
        if (data != null) {
            this.data = data;
        } else {
            throw new IllegalArgumentException("dataInvalida");
        }
    }
}
