/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho.Entidades;

import trabalho.TiposBasicos.Data;

public class Copa {

    private int ano;
    private int pais;
    private Data inicio;
    private Data fim;

    int getAno() {
        return this.ano;
    }

    int getPais() {
        return this.pais;
    }

    Data getInicio() {
        return this.inicio;
    }

    Data getFim() {
        return this.fim;
    }

    void setAno(int ano) throws IllegalArgumentException {
        if (ano > 1800) {
            this.ano = ano;
        } else {
            throw new IllegalArgumentException("ano invalido");
        }
    }

    void setPais(int pais) throws IllegalArgumentException {
        if (pais > 0) {
            this.pais = pais;
        } else {
            throw new IllegalArgumentException("pais invalido");
        }
    }

    void setIncio(Data inicio) throws IllegalArgumentException {
        if (inicio != null) {
            this.inicio = inicio;
        } else {
            throw new IllegalArgumentException("data de inicio vazia");
        }
    }

    void setFim(Data fim) throws IllegalArgumentException {
        if (fim != null) {
            this.fim = fim;
        } else {
            throw new IllegalArgumentException("data de termino vazia");
        }
    }
}
