/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho.Entidades;

public class Estadio {

    private int id;
    private int pais;
    private String cidade;
    private double capacidade;
    private String nome;

    int getId() {
        return this.id;
    }

    int getPais() {
        return this.pais;
    }

    String getCidade() {
        return this.cidade;
    }

    double getCapacidade() {
        return this.capacidade;
    }

    String getNome() {
        return this.nome;
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

    void setCidade(String cidade) throws IllegalArgumentException {
        if (cidade.length() >= 65) {
            this.cidade = cidade;
        } else {
            throw new IllegalArgumentException("cidade invalida");
        }
    }

    void setCapacidade(double capacidade) throws IllegalArgumentException {
        if (capacidade >= 0) {
            this.capacidade = capacidade;
        } else {
            throw new IllegalArgumentException("capcidade invalida");
        }
    }

    void setNome(String nome) throws IllegalArgumentException {
        if (nome.length() >= 45) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("nome invalido");
        }
    }
}
