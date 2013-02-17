/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho.Entidades;

public class Equipe {

    private int id;
    private int treinador;
    private int pais;
    private int copa;

    int getId() {
        return this.id;
    }

    int getTreinador() {
        return this.treinador;
    }

    int getPais() {
        return this.pais;
    }

    int getCopa() {
        return this.copa;
    }

    void setId(int id) throws IllegalArgumentException {
        if (id >= 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("id invalido");
        }
    }

    void setTreinador(int treinador) throws IllegalArgumentException {
        if (treinador >= 0) {
            this.treinador = treinador;
        } else {
            throw new IllegalArgumentException("id do treinador invalido");
        }
    }

    void setPais(int pais) throws IllegalArgumentException {
        if (pais >= 0) {
            this.pais = pais;
        } else {
            throw new IllegalArgumentException("pais invalido");
        }
    }

    void setCopa(int copa) throws IllegalArgumentException {
        if (copa >= 1800) {
            this.copa = copa;
        } else {
            throw new IllegalArgumentException("copa invalida");
        }
    }
}
