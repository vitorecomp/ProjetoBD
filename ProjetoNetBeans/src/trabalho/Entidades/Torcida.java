/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho.Entidades;

import trabalho.TiposBasicos.Foto;

public class Torcida {

    private int id;
    private int pais;
    private Foto foto;
    private int presidente;

    int getId() {
        return this.id;
    }

    int getPais() {
        return this.pais;
    }

    Foto getFoto() {
        return this.foto;
    }
    
    int getPresidente()
    {
        return this.presidente;
    }
    
    void setId(int id) throws IllegalArgumentException {
        if (id >= 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("id invalido");
        }
    }
    void setPais(int pais) throws IllegalArgumentException {
        if (pais >= 0) {
            this.pais = pais;
        } else {
            throw new IllegalArgumentException("pais invalido");
        }
    }
    void setFoto(Foto foto) throws IllegalArgumentException {
        if (foto != null) {
            this.foto = foto;
        } else {
            throw new IllegalArgumentException("foto vazia");
        }
    }
    void setPresidente(int presidente) throws IllegalArgumentException {
        if (presidente >= 0) {
            this.presidente = presidente;
        } else {
            throw new IllegalArgumentException("presidente invalido");
        }
    }
}