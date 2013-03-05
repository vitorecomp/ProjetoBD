/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho.Entidades;



public class Jogo {

    private int id;
    private String data;
    private int copa;
    private int equipe1;
    private int equipe2;

    int getId() {
        return this.id;
    }

    String getData() {
        return this.data;
    }

    int getCopa() {
        return this.copa;
    }

    int getEquipe1() {
        return this.equipe1;
    }

    int getEquipe2() {
        return this.equipe2;
    }

    void setId(int id) throws IllegalArgumentException {
        if (id >= 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("id invalido");
        }
    }

    void setData(String data) throws IllegalArgumentException {
        if (data != null) {
            this.data = data;
        } else {
            throw new IllegalArgumentException("campo data vazio");
        }
    }

    void setCopa(int copa) throws IllegalArgumentException {
        if (copa >= 1800) {
            this.copa = copa;
        } else {
            throw new IllegalArgumentException("copa invalida");
        }
    }

    void setEquipe1(int equipe1) throws IllegalArgumentException {
        if (equipe1 >= 0) {
            this.equipe1 = equipe1;
        } else {
            throw new IllegalArgumentException("Equipe invalida");
        }
    }

    void setEquipe2(int equipe2) throws IllegalArgumentException {
        if (equipe2 >= 0) {
            this.equipe2 = equipe2;
        } else {
            throw new IllegalArgumentException("Equipe invalida");
        }
    }
}
