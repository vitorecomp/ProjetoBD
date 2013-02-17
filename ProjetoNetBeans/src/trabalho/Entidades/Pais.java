/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho.Entidades;

import trabalho.TiposBasicos.Foto;

public class Pais {

    private int id;
    private String nome;
    private String sigla;
    private String capital;
    private Foto bandeira;

    int getId() {
        return this.id;
    }

    String getNome() {
        return this.nome;
    }

    String getSigla() {
        return this.sigla;
    }

    String getCapital() {
        return this.capital;
    }

    Foto getFoto() {
        return this.bandeira;
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

    void setSigla(String sigla) throws IllegalArgumentException {
        if (sigla.length() <= 3) {
            this.sigla = sigla;
        } else {
            throw new IllegalArgumentException("sigla invalida");
        }
    }

    void setCapital(String Capital) throws IllegalArgumentException {
        if (capital.length() <= 45) {
            this.capital = capital;
        } else {
            throw new IllegalArgumentException("capital invalida");
        }
    }

    void setFoto(Foto foto) throws IllegalArgumentException {
        if (foto != null) {
            this.bandeira = foto;
        } else {
            throw new IllegalArgumentException("bandeira invalida");
        }
    }
}
