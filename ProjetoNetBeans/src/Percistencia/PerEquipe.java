
package Percistencia;

import Trabalho.Entidades.Equipe;
import java.sql.*;

public class PerEquipe {
    void create(Equipe equipe)
    {
        try{
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "INSERT INTO Equipe";
        }catch(SQLException e){
            
        }
    }
    
    void update(Equipe equipe)
    {
        
    }
    
    void delete(int id)
    {
        
    }
}
