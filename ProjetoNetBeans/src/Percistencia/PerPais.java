/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Percistencia;

import java.sql.*;
import Trabalho.Entidades.Pais;

/**
 *
 * @author Vitor
 */
public class PerPais {

    public void inserePais(Pais pais) {
        try {
            Connection con = BancoDeDados.getConexao();
            Statement stmt = con.createStatement();
            String comandoSQL = "INSERT INTO TB_USUARIO(NOME, ENDERECO, EMAIL)"
                    + " VALUES ('" + pais.getNome() + "','" + pais.getId() + "','" + pais.getSigla() + "' ) ";
            stmt.executeUpdate(comandoSQL);
            stmt.close();
            con.commit();
            con.close();
        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexão com o BD");
        }
    }

    void update(Pais pais) {
    }

    void delete(int id) {
    }
}
