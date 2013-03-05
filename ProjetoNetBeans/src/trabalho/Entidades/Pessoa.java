/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho.Entidades;



public class Pessoa {

    private int id;
    private String nome;
    private String datanasc;

    int getId() {
        return this.id;
    }

    String getString() {
        return this.nome;
    }

    String getData() {
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
    
    void setData(String dataNasc) throws IllegalArgumentException {
        if (dataNasc != null) {
            this.datanasc = dataNasc;
        } else {
            throw new IllegalArgumentException("data vazia");
        }
    }
}