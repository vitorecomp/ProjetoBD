/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho.Entidades;

import trabalho.TiposBasicos.Tempo;

public class Gol {

    private int id;
    private int jogo;
    private int autor;
    private int tempo;
    private Tempo hora;

    int getId() {
        return this.id;
    }

    int getJogo() {
        return this.jogo;
    }

    int getAutor() {
        return this.autor;
    }

    int getTempo() {
        return this.tempo;
    }

    Tempo getHora() {
        return this.hora;
    }

    void setId(int id) throws IllegalArgumentException {
        if (id >= 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("id invalido");
        }
    }

    void setJogo(int jogo) throws IllegalArgumentException {
        if (jogo >= 0) {
            this.jogo = jogo;
        } else {
            throw new IllegalArgumentException("jogo invalido");
        }
    }

    void setAutor(int autor) throws IllegalArgumentException {
        if (autor >= 0) {
            this.autor = autor;
        } else {
            throw new IllegalArgumentException("autor invalido");
        }
    }

    void setTempo(int tempo) throws IllegalArgumentException {
        if (tempo > 0 && tempo < 5) {
            this.tempo = tempo;
        }else{
            throw new IllegalArgumentException("tempo invalido");
        }
    }

    void setHora(Tempo hora) throws IllegalArgumentException {
        if (hora != null) {
            this.hora = hora;
        } else {
            throw new IllegalArgumentException("campo hora vazio");
        }
    }
}
