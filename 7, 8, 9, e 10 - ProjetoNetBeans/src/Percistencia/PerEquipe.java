package Percistencia;

import Trabalho.Entidades.Equipe;
import java.util.Vector;
import java.sql.*;

public class PerEquipe {

    public void create(Equipe equipe) {
        try {
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "INSERT INTO Equipe(idTreinador, idPais, idCopa)" + "VALUES(" + equipe.getTreinador() + "," + equipe.getPais() + "," + equipe.getCopa() + ");";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(41);
        }
    }

    public void update(Equipe equipe) {
        try {
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "UPDATE Equipe SET idTreinador=" + equipe.getTreinador() + ", idPais=" + equipe.getPais() + ",idCopa=" + equipe.getCopa() + " WHERE idEquipe=" + equipe.getId() + ";";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(42);
        }
    }

    public void delete(int id) {
        try {
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();

            stmt.executeUpdate("Delete FROM Equipe WHERE id = " + id + ";");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(43);
        }
    }

    public Vector<Equipe> selectAllequipesOfpais(int id_pais) {

        Vector<Equipe> listaEquipe = new Vector();
        Equipe equipe = null;

        try {
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Equipe WHERE idPais=" + id_pais + ";";
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
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

        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(43);
        }
        return listaEquipe;
    }

    public Vector<Equipe> selectAllequipesofCopa(int id_copa) {
        Vector<Equipe> listaEquipe = new Vector();
        Equipe equipe = null;
        try {
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Equipe WHERE idPais=" + id_copa + ";";
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
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

        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(44);
        }
        return listaEquipe;
    }

    public Equipe selectEquipe(int id_equipe) {

        Equipe equipe = null;
        try {
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Equipe WHERE idEquipe=" + id_equipe + ";";
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
                equipe = new Equipe();
                equipe.setId(res.getInt("idEquipe"));
                equipe.setCopa(res.getInt("idCopa"));
                equipe.setTreinador(res.getInt("idTreinador"));
                equipe.setPais(res.getInt("idPais"));

            }
            stmt.close();
            con.close();

            return equipe;

        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(45);
        }
        return equipe;
    }

    public Vector<Equipe> selectAll() {
        Vector<Equipe> listaEquipe = new Vector();
        Equipe equipe = null;
        try {
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Equipe;";
            ResultSet res = stmt.executeQuery(query);

            while (res.next()) {
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

        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(46);
        }
        return listaEquipe;
    }
}
