/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho.Entidades;

import trabalho.TiposBasicos.Data;

public class Copa {

    public Copa(){
    }   
    
    private int ano;
    private int pais;
    private Data inicio;
    private Data fim;
    private int camp;

   public int getAno() {
        return this.ano;
        }

   public int getPais() {
        return this.pais;
        }

  public Data getInicio() {
        return this.inicio;
        }

  public Data getFim() {
        return this.fim;
        }

   public void setAno(int newano) throws IllegalArgumentException {
        if (newano >= 1800) {
            this.ano = newano;
        } else {
            throw new IllegalArgumentException("ano invalido");
        }
    }

   public void setPais(int newpais) throws IllegalArgumentException {
        if (newpais >= 0) {
            this.pais = newpais;
        } else {
            throw new IllegalArgumentException("pais invalido");
        }
    }

   public void setInicio(Data newinicio) throws IllegalArgumentException {
        if (newinicio != null) {
            this.inicio = newinicio;
        } else {
            throw new IllegalArgumentException("data de inicio vazia");
        }
    }

   public void setFim(Data newfim) throws IllegalArgumentException {
        if (newfim != null) {
            this.fim = newfim;
        } else {
            throw new IllegalArgumentException("data de termino vazia");
        }
    }
   
   public void setCamp(int newcamp) throws IllegalArgumentException {
        if (newcamp >= 0) {
            this.camp = newcamp;
        } else {
            throw new IllegalArgumentException("equipe campea invalida");
        }
    }
}
