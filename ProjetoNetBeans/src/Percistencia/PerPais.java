/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Percistencia;

import java.sql.*;
import java.util.*;
import Trabalho.Entidades.Pais;

/**
 *
 * @author Vitor
 */
public class PerPais {

    public void inserePais(Pais pais) {
        
        try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "insert into Integrantes(idIntegrantes, Nome, Nacionalidade, Pais_Nasc) values (1, 'Pierre', 'Frances', 'França');";
            stmt.executeUpdate(query);
            stmt.close();
            con.commit();
            con.close();
        }catch(SQLException e){
            System.exit(6);
        }   
    }

    public void updatePais(Pais pais) {
       try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "UPDATE Paises SET nome=" + pais.getNome() + ",sigla=" + pais.getSigla() + ", capital=" + pais.getCapital() + "bandeira=" + pais.getBandeira() + "WHERE id=" + pais.getId() + ";";
            stmt.executeUpdate(query);
            stmt.close();
            con.commit();
            con.close();
        }catch(SQLException e){
            
        }
  }
    
    public void deletePais(int id) {
        try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate("Delete FROM Paises WHERE id = " + id + ";");
            stmt.close();
        }catch(SQLException e){
            
        }
    }
    
    public Pais selectPais(int id){
        
        try{
            Connection con = BancodeDados.getConexao();
            Pais pais = new Pais();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Paises WHERE id=" + id + ";";
            ResultSet res = stmt.executeQuery(query);
            
            if(res.next()){
                pais = new Pais();
                pais.setId(res.getInt("id"));
                pais.setNome(res.getString("nome"));
                pais.setSigla(res.getString("sigla"));
                pais.setCapital(res.getString("capital"));
                //pais.setFoto(res.getBlob());
            }
            stmt.close();
            con.close();
            
            return pais;            
        }catch(SQLException e){
            return null;
        }
    }
    
    public Vector selectAll(){
        Vector listaPais = new Vector();
        Pais pais = null;
        
        try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Paises";
            ResultSet res = stmt.executeQuery(query);
            
            if(res.next()){
                pais = new Pais();
                pais.setId(res.getInt("id"));
                pais.setNome(res.getString("nome"));
                pais.setSigla(res.getString("sigla"));
                pais.setCapital(res.getString("capital"));
                //pais.setFoto(res.getBlob());
                listaPais.add(pais);
            }
            stmt.close();
            con.close();
            
            return listaPais;
            
        }catch(SQLException e){
            System.exit(5);
            return null;
        }
    }
    
    
}
