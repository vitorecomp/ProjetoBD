/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho.Entidades;

import trabalho.TiposBasicos.*;

public class Integrante {

    private int id;
    private String nome;
    private Data dataNasc;
    private Foto foto;

    int getId() {
        return this.id;
    }

    String getNome() {
        return this.nome;
    }

    Data getDatanasc() {
        return this.dataNasc;
    }

    Foto getFoto() {
        return this.foto;
    }

    void setId(int id) throws IllegalArgumentException {
        if (id >= 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("id invalido");
        }
    }

    void setNome(String nome) throws IllegalArgumentException {
        if (nome.length() >= 45) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("nome invalido");
        }
    }

    void setDataNasc(Data dataNasc) throws IllegalArgumentException {
        if (dataNasc != null) {
            this.dataNasc = dataNasc;
        } else {
            throw new IllegalArgumentException("data vazia");
        }
    }

    void setFoto(Foto foto) throws IllegalArgumentException {
        if (foto != null) {
            this.foto = foto;
        } else {
            throw new IllegalArgumentException("campo foto vazio");
        }
    }

}
