
package Percistencia;

import Trabalho.Entidades.Equipe;
import java.util.Vector;
import java.sql.*;


public class PerEquipe {
    public void create(Equipe equipe)
    {
        try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "INSERT INTO Equipe(idTrinador, idPais, idCopa)" + "VALUES(" + equipe.getTreinador() + "," + equipe.getPais() + "," + equipe.getCopa() + ");";
            stmt.executeUpdate(query);
            stmt.close();
            con.commit();
            con.close();
        }catch(SQLException e){
            
        }
    }
    
    public void update(Equipe equipe)
    {
        try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "UPDATE Equipe SET Treinador="  + equipe.getTreinador() + ", Pais=" + equipe.getPais() + ",Copa=" + equipe.getCopa() + "WHERE idEquipe=" + equipe.getId() +";";
            stmt.executeUpdate(query);
            stmt.close();
            con.commit();
            con.close();
        }catch(SQLException e){
            
        }
    }
    
    public void delete(int id)
    {
        try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate("Delete FROM Equipe WHERE id = "+id+";");
            stmt.close();
        }catch(SQLException e){
            
        }
    }
    
    public Vector<Equipe> selectAllequipesOfpais(int id_pais){
    
            Vector<Equipe> listaEquipe = new Vector();
            Equipe equipe = null;
            
        try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Equipe WHERE idPais=" + id_pais + ";";
            ResultSet res = stmt.executeQuery(query);
            
            if(res.next()){
                equipe = new Equipe();
                equipe.setId(res.getInt("idEquipe"));
                equipe.setCopa(res.getInt("idCopa"));
                equipe.setTreinador(res.getInt("idTreinador"));
                equipe.setPais(res.getInt("idPais"));
                listaEquipe.add(equipe);
            }
            stmt.close();
            con.close();
            
            return listaEquipe;
            
        }catch(SQLException e){
            return null;
        }
    }
    
    public Vector<Equipe> selectAllequipesofCopa(int id_copa){
        Vector<Equipe> listaEquipe = new Vector();
            Equipe equipe = null;
        try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Equipe WHERE idPais=" + id_copa + ";";
            ResultSet res = stmt.executeQuery(query);
            
            if(res.next()){
                equipe = new Equipe();
                equipe.setId(res.getInt("idEquipe"));
                equipe.setCopa(res.getInt("idCopa"));
                equipe.setTreinador(res.getInt("idTreinador"));
                equipe.setPais(res.getInt("idPais"));
                listaEquipe.add(equipe);
            }
            stmt.close();
            con.close();
            
            return listaEquipe;
            
        }catch(SQLException e){
            return null;
        }
    }
    
    public Vector<Equipe> selectEquipe(int id_equipe){
        Vector<Equipe> listaEquipe = new Vector();
            Equipe equipe = null;
        try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Equipe WHERE idPais=" + id_equipe + ";";
            ResultSet res = stmt.executeQuery(query);
            
            if(res.next()){
                equipe = new Equipe();
                equipe.setId(res.getInt("idEquipe"));
                equipe.setCopa(res.getInt("idCopa"));
                equipe.setTreinador(res.getInt("idTreinador"));
                equipe.setPais(res.getInt("idPais"));
                listaEquipe.add(equipe);
            }
            stmt.close();
            con.close();
            
            return listaEquipe;
            
        }catch(SQLException e){
            return null;
        }
    }
    
    public Vector<Equipe> selectAll(){
        Vector<Equipe> listaEquipe = new Vector();
            Equipe equipe = null;
        try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Equipe;";
            ResultSet res = stmt.executeQuery(query);
            
            if(res.next()){
                equipe = new Equipe();
                equipe.setId(res.getInt("idEquipe"));
                equipe.setCopa(res.getInt("idCopa"));
                equipe.setTreinador(res.getInt("idTreinador"));
                equipe.setPais(res.getInt("idPais"));
                listaEquipe.add(equipe);
            }
            stmt.close();
            con.close();
            
            return listaEquipe;
            
        }catch(SQLException e){
            return null;
        }
    }
    

}
