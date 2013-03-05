/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Percistencia;

import java.sql.*;
import java.util.*;
import Trabalho.Entidades.Copa;

/**
 *
 * @author Vitor
 */
public class PerCopa {

   public void insereCopa(Copa copa) {
        try {
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String comandoSQL;
            comandoSQL = "INSERT INTO Copa(ano, pais, inio, fim)"
             + " VALUES ('" + copa.getAno() + "','" + copa.getPais() + "','" + copa.getInicio() + "','" + copa.getFim() + "' ) ";
            stmt.executeUpdate(comandoSQL);
            stmt.close();
            con.commit();
            con.close();
        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexão com o BD");
        }
    }

 public void updateCopa(Copa copa) {
     try{
        Connection con = BancodeDados.getConexao();
        Statement stmt = con.createStatement();
    
        String query = "UPDATE Copa SET Ano =" + copa.getAno() + ", Pais =" + copa.getPais() + ", Inicio =" + copa.getInicio() + ", Fim =" + copa.getFim() + "WHERE ano =" + copa.getAno() + ";";
        stmt.executeUpdate(query);
        stmt.close();
        con.commit();
        con.close();
    } catch(SQLException e){
        System.out.println("Problemas ao abrir a conexão com o BD");
      }    
 }     
 
 public Copa selecionaCopa(int ano){
     
     try{
        Connection con = BancodeDados.getConexao();
        Copa copa = new Copa();
        Statement stat = con.createStatement();
        ResultSet res = stat.executeQuery("SELECT * FROM Copa where ano = "+ano);
        if(res.next()) {
        copa.setAno(res.getInt("Ano"));
        copa.setPais(res.getInt("Pais"));
        //copa.setInicio(res.getDate("Inicio"));  
        //copa.setFim(res.getDate("Fim"));
        stat.close();
        con.close();
        }
     return copa;
     }catch(SQLException e){
        System.out.println("Problemas ao abrir a conexao com o BD");
        return null;
        }
}
 
 public Vector selecionaTodasCopas(){
     
    Vector listaCopas = new Vector();
    Copa copa = null;
    
    try{
    Connection con = BancodeDados.getConexao();
    Statement stmt = con.createStatement();
    String query = "SELECT * FROM Copa" ;
    ResultSet res = stmt.executeQuery(query);
    while (res.next() ){
    copa = new Copa();
    copa.setAno(res.getInt("Ano"));
    copa.setPais(res.getInt("Pais"));
    //copa.setInicio(res.getDate("Inicio"));
    //copa.setFim(res.getDate("Fim"));
    listaCopas.add(copa);
    }
    stmt.close();
    con.close();
    return listaCopas;
    }catch(SQLException e){
        System.out.println("Problemas ao abrir a conexao com o BD");
        return null;
    }
}

 public Vector selecionaTodasCopasDoPais(int idPais){
     
    Vector listaCopas = new Vector();
    Copa copa = null;
    
    try{
    Connection con = BancodeDados.getConexao();
    Statement stmt = con.createStatement();
    String query = "SELECT * FROM Copa WHERE pais =" + idPais + ";" ;
    ResultSet res = stmt.executeQuery(query);
    
    while (res.next() ){
        copa = new Copa();
        copa.setAno(res.getInt("Ano"));
        copa.setPais(res.getInt("Pais"));
        //copa.setInicio(res.getDate("Inicio"));
        //copa.setFim(res.getDate("Fim"));
        listaCopas.add(copa);
    }
    stmt.close();
    con.close();
    
    return listaCopas;
    }catch(SQLException e){
        System.out.println("Problemas ao abrir a conexao com o BD");
        return null;
     }
}
 
 public Vector selecionaTodasCopasPorCampeao(int idCamp){
     
    Vector listaCopas = new Vector();
    Copa copa = null;
    
    try{
    Connection con = BancodeDados.getConexao();
    Statement stmt = con.createStatement();
    String query = "SELECT * FROM Copa WHERE Camp=" + idCamp + ";" ;
    ResultSet res = stmt.executeQuery(query);
    while (res.next() ){
    copa = new Copa();
    copa.setAno(res.getInt("Ano"));
    copa.setPais(res.getInt("Pais"));
    //copa.setInicio(res.getDate("Inicio"));
    //copa.setFim(res.getDate("Fim"));
    listaCopas.add(copa);
    }
    stmt.close();
    con.close();
    return listaCopas;
    }catch(SQLException e){
        System.out.println("Problemas ao abrir a conexao com o BD");
        return null;
    }
}
 
 public int deletaCopa(int ano){
    
    try{
    Connection con = BancodeDados.getConexao();
    Statement stat = con.createStatement();
    stat.executeUpdate("Delete FROM Copa WHERE ano = "+ano);
    stat.close();
    return(1);
    }catch(SQLException e)
    {
    return(0);
    }
 }
}

