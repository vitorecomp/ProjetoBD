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
        if (ano >= 1800) {
            this.ano = newano;
        } else {
            throw new IllegalArgumentException("ano invalido");
        }
    }

   public void setPais(int newpais) throws IllegalArgumentException {
        if (pais >= 0) {
            this.pais = newpais;
        } else {
            throw new IllegalArgumentException("pais invalido");
        }
    }

   public void setInicio(Data newinicio) throws IllegalArgumentException {
        if (inicio != null) {
            this.inicio = newinicio;
        } else {
            throw new IllegalArgumentException("data de inicio vazia");
        }
    }

   public void setFim(Data newfim) throws IllegalArgumentException {
        if (fim != null) {
            this.fim = newfim;
        } else {
            throw new IllegalArgumentException("data de termino vazia");
        }
    }
}
