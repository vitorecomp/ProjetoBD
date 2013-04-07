/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Percistencia;

import java.sql.*;
import java.util.*;
import Trabalho.Entidades.Copa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

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

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

            java.util.Date convertedDate1 = dateFormat.parse(copa.getInicio());
            java.util.Date convertedDate2 = dateFormat.parse(copa.getFim());


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String Date1 = sdf.format(convertedDate1);
            String Date2 = sdf.format(convertedDate2);



            comandoSQL = "INSERT INTO Copa(ano, Idpais, camp, DataIni, datafim)"
                    + " VALUES ('" + copa.getAno() + "','" + copa.getPais() + "','" + copa.getCamp() + "','" + Date1 + "','" + Date2 + "' ) ";
            stmt.executeUpdate(comandoSQL);
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(31);
        } catch (ParseException ex) {
            Logger.getLogger(PerCopa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCopa(Copa copa) {
        try {
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

            java.util.Date convertedDate1 = dateFormat.parse(copa.getInicio());
            java.util.Date convertedDate2 = dateFormat.parse(copa.getFim());


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String Date1 = sdf.format(convertedDate1);
            String Date2 = sdf.format(convertedDate2);


            String query = "UPDATE Copa SET Ano =" + copa.getAno() + ", idPais ='" + copa.getPais() + "', DataIni ='" + Date1 + "', DataFim ='" + Date2 + "' WHERE ano =" + copa.getAno() + ";";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(32);
        } catch (ParseException ex) {
            Logger.getLogger(PerCopa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Copa selecionaCopa(int ano) {

        Copa copa = null;
        try {
            Connection con = BancodeDados.getConexao();
            copa = new Copa();
            Statement stat = con.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM Copa where ano = " + ano);
            if (res.next()) {
                copa.setAno(res.getInt("Ano"));
                copa.setPais(res.getInt("idPais"));
                copa.setCamp(res.getInt("camp"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String Date1 = sdf.format(res.getDate("dataini"));
                String Date2 = sdf.format(res.getDate("datafim"));


                copa.setInicio(Date1);
                copa.setFim(Date2);
                stat.close();
                con.close();
            }
            return copa;
        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(34);
        }
        return copa;
    }

    public Vector selecionaTodasCopas() {

        Vector listaCopas = new Vector();
        Copa copa = null;

        try {
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM copa;";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                copa = new Copa();
                copa.setAno(res.getInt("Ano"));
                copa.setPais(res.getInt("idPais"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String Date1 = sdf.format(res.getDate("dataini"));
                String Date2 = sdf.format(res.getDate("datafim"));


                copa.setInicio(Date1);
                copa.setFim(Date2);
                listaCopas.add(copa);
            }
            stmt.close();
            con.close();
            return listaCopas;
        } catch (SQLException e) {

            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(34);
        }
        return listaCopas;
    }

    public Vector selecionaTodasCopasDoPais(int idPais) {

        Vector listaCopas = new Vector();
        Copa copa = null;

        try {
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Copa WHERE pais =" + idPais + ";";
            ResultSet res = stmt.executeQuery(query);

            while (res.next()) {
                copa = new Copa();
                copa.setAno(res.getInt("Ano"));
                copa.setPais(res.getInt("idPais"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String Date1 = sdf.format(res.getDate("dataini"));
                String Date2 = sdf.format(res.getDate("datafim"));


                copa.setInicio(Date1);
                copa.setFim(Date2);
                listaCopas.add(copa);
            }
            stmt.close();
            con.close();

            return listaCopas;
        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(34);
        }
        return listaCopas;
    }

    public Vector selecionaTodasCopasPorCampeao(int idCamp) {

        Vector listaCopas = new Vector();
        Copa copa = null;

        try {
            Connection con = BancodeDados.getConexao();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Copa WHERE Camp=" + idCamp + ";";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                copa = new Copa();
                copa.setAno(res.getInt("Ano"));
                copa.setPais(res.getInt("idPais"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String Date1 = sdf.format(res.getDate("dataini"));
                String Date2 = sdf.format(res.getDate("datafim"));


                copa.setInicio(Date1);
                copa.setFim(Date2);
                listaCopas.add(copa);
            }
            stmt.close();
            con.close();
            return listaCopas;
        } catch (SQLException e) {
            System.out.println("Problemas ao abrir a conexao com o BD" + e);
            System.exit(35);
        }
        return listaCopas;
    }

    public int deletaCopa(int ano) {

        try {
            Connection con = BancodeDados.getConexao();
            Statement stat = con.createStatement();
            stat.executeUpdate("Delete FROM Copa WHERE ano = " + ano);
            stat.close();
            return (1);
        } catch (SQLException e) {
            return (0);
        }
    }
}
