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
            String query = "INSERT INTO PAIS(nome, sigla, capital) VALUES ('"+pais.getNome()+"', '"+pais.getSigla()+
                    "', '"+pais.getCapital()+"');";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(21);
        }   
    }

    public void updatePais(Pais pais) {
       try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "UPDATE Paises SET nome=" + pais.getNome() + ",sigla=" + pais.getSigla() + ", capital=" + pais.getCapital() + "WHERE idPais=" + pais.getId() + ";";
            stmt.executeUpdate(query);
            stmt.close();
            con.commit();
            con.close();
        }catch(SQLException e){
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(22);
        }
  }
    
    public void deletePais(int id) {
        try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate("Delete FROM Pais WHERE idPais = " + id + ";");
            stmt.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(23);
        }
    }
    
    public Pais selectPais(int id){
        
        Pais pais = null;
        try{
            Connection con = BancodeDados.getConexao();
            
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Pais WHERE idPais=" + id + ";";
            ResultSet res = stmt.executeQuery(query);
            pais = new Pais();
            if(res.next()){
                pais = new Pais();
                pais.setId(res.getInt("idPais"));
                pais.setNome(res.getString("nome"));
                pais.setSigla(res.getString("sigla"));
                pais.setCapital(res.getString("capital"));
                //pais.setFoto(res.getBlob());
            }
            stmt.close();
            con.close();
            
            return pais;            
        }catch(SQLException e){
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(23);
        }
        return pais;
    }
    
    public Vector selectAll(){
        Vector listaPais = new Vector();
        Pais pais = null;
        
        try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Pais";
            ResultSet res = stmt.executeQuery(query);
            
            while(res.next()){
                pais = new Pais();
                pais.setId(res.getInt("idPais"));
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
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(26);
        }
        return listaPais;
    }
    
    
}
