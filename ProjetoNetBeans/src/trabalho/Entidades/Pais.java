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
    private String bandeira;

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getCapital() {
        return this.capital;
    }

    public String getFoto() {
        return this.bandeira;
    }

    public void setId(int id) throws IllegalArgumentException {
        if (id >= 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("id invalido");
        }
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome.length() <= 45) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("nome invalido");
        }
    }

    public void setSigla(String sigla) throws IllegalArgumentException {
        if (sigla.length() <= 3) {
            this.sigla = sigla;
        } else {
            throw new IllegalArgumentException("sigla invalida");
        }
    }

    public void setCapital(String Capital) throws IllegalArgumentException {
        if (capital.length() <= 45) {
            this.capital = capital;
        } else {
            throw new IllegalArgumentException("capital invalida");
        }
    }

    public void setFoto(String foto) throws IllegalArgumentException {
        if (foto != null) {
            this.bandeira = foto;
        } else {
            throw new IllegalArgumentException("bandeira invalida");
        }
    }
}
