/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Percistencia;

/**
 *
 * @author Vitor
 */
import java.sql.*;

public class BancodeDados {
    // Access

    private static String DRIVER_BD = "sun.jdbc.odbc.JdbcOdbcDriver";
    private static String URL_BD = "jdbc:mysql://localhost";
    private static String usuario = "";
    private static String senha = "";
    private static Connection con;

    public BancodeDados() {
        try {
            Class.forName(DRIVER_BD);
        } catch (ClassNotFoundException e) {
            System.out.println("Problemas ao carregar o driver");
        }
    }

    public static Connection getConexao() {
        try {
            if ((con == null) || (con.isClosed())) {
                con = DriverManager.getConnection(URL_BD, usuario, senha);
            }
        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexao com o BD");
        }
        return con;
    }
}