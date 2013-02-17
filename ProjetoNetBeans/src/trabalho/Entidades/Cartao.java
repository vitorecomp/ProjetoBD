/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho.Entidades;

import trabalho.TiposBasicos.*;

public class Cartao {

    private int id;
    private int jogador;
    private char tipo;
    private Tempo tempo;

    int getId() {
        return this.id;
    }

    int getJogador() {
        return this.jogador;
    }

    char getTipo() {
        return this.tipo;
    }

    Tempo getTempo() {
        return this.tempo;
    }

    void setId(int id) throws IllegalArgumentException {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("idInvalido");
        }
    }

    void setJogador(int jogador) throws IllegalArgumentException {
        if (jogador > 0) {
            this.jogador = jogador;

        } else {
            throw new IllegalArgumentException("jogador invalido");
        }

    }

    void setTipo(char tipo) throws IllegalArgumentException {
        if (tipo == 'V' || tipo == 'A') {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("Tipo de Cartao Invalido");
        }
    }

    void setTempo(Tempo tempo) throws IllegalArgumentException {
        if (tempo != null) {
            this.tempo = tempo;
        } else {
            throw new IllegalArgumentException("tempo vazio");
        }
    }
}
