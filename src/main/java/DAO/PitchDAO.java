/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.democrud.Pitch;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

/**
 *
 * @author ADMIN
 */
public class PitchDAO extends ConnectDB<Pitch, Integer> {

    public ObservableList<Pitch> fieldsList = FXCollections.observableArrayList();

    public PitchDAO() {
    }

    @Override
    public void Update(Integer id, Pitch t) {
        int idp = id;
        String name = t.getName();
        int available = t.getAvailable();

        String query = "UPDATE sanbong SET name = '" + name + "', available = " + available + " WHERE idcp = " + idp;

        executeSQL(query);

        System.out.println("UPDATED !");
    }

    @Override
    public void Insert(Pitch t) {
        int idcp = t.getIdcp();
        String name = t.getName();
        int available = t.getAvailable();

        String query = "INSERT INTO sanbong(idcp, name, available) VALUES (" + idcp + ",'" + name + "'," + available + ")";

        executeSQL(query);

        System.out.println("INSERTED !");
    }

    @Override
    public void Delete(Integer id) {
        String query = "DELETE sanbong WHERE idp = " + id;
        executeSQL(query);
        System.out.println("DELETED !");
    }

    @Override
    public ObservableList<Pitch> getAll() {

        Connection cn = getConnection();

        String query = "SELECT cat_san.size, cat_san.price, sanbong.*"
                + "FROM sanbong INNER JOIN cat_san ON sanbong.[idcp] = cat_san.[idcp];";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            int no = 0;
            while (rs.next()) {

                int idcp = rs.getInt("idcp");
                String size = rs.getString("size"); //field trong database
                int price = rs.getInt("price");
                int idp = rs.getInt("idp");
                String name = rs.getString("name");
                int available = rs.getInt("available");
                no++;
                Pitch p = new Pitch(idp, name, available, idcp, size, price, no);
                fieldsList.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return fieldsList;
    }

    public ObservableList<Pitch> getByIDcategory(int idcp) {

        Connection cn = getConnection();
        //truy van
        String query = "SELECT sanbong.*, cat_san.size, cat_san.price "
                + "FROM  sanbong "
                + "INNER JOIN "
                + "cat_san on sanbong.idcp = cat_san.idcp "
                + "WHERE cat_san.idcp = " + idcp;
        //thuc thi
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);
            Pitch p;
            int no = 0;
            while (rs.next()) {
                String size = rs.getString("size"); //field trong database
                int price = rs.getInt("price");
                int idp = rs.getInt("idp");
                String name = rs.getString("name");
                int available = rs.getInt("available");
                no++;
                p = new Pitch(idp, name, available, idcp, size, price, no);
                fieldsList.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return fieldsList;
    }

    public ObservableList<Pitch> getByAvailable(int available) {

        Connection cn = getConnection();
        //truy van
        String query = "SELECT sanbong.*, cat_san.size, cat_san.price "
                + " FROM  sanbong"
                + " INNER JOIN"
                + " cat_san on sanbong.idcp = cat_san.idcp"
                + " WHERE sanbong.available =" + available;
        System.out.println("String query: " + query);
        //thuc thi
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);
            Pitch p;
            int no = 0;
            while (rs.next()) {
                int idcp = rs.getInt("idcp");

                String size = rs.getString("size"); //field trong database
                int price = rs.getInt("price");
                int idp = rs.getInt("idp");
                String name = rs.getString("name");
                no++;
                p = new Pitch(idp, name, available, idcp, size, price, no);
                fieldsList.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return fieldsList;
    }

    public int getAvailableByID(int id) {
        for (Pitch f : fieldsList) {
            if (f.getIdp() == id) {
                return f.getAvailable();
            }
        }
        return 0;
    }
}
