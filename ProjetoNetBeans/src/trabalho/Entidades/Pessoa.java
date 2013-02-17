/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho.Entidades;

import trabalho.TiposBasicos.Data;

public class Pessoa {

    private int id;
    private String nome;
    private Data datanasc;

    int getId() {
        return this.id;
    }

    String getString() {
        return this.nome;
    }

    Data getData() {
        return this.datanasc;
    }
    
    void setId(int id) throws IllegalArgumentException {
        if (id >= 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("id invalido");
        }
    }
    
    void setNome(String nome) throws IllegalArgumentException {
        if (nome.length() <= 45) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("nome invalido");
        }
    }
    
    void setData(Data dataNasc) throws IllegalArgumentException {
        if (dataNasc != null) {
            this.datanasc = dataNasc;
        } else {
            throw new IllegalArgumentException("data vazia");
        }
    }
}