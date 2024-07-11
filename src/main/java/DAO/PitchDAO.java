/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.Booking;
import com.mycompany.group4_project.Pitch;

import java.net.PortUnreachableException;
import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * @author ADMIN
 */
public class PitchDAO extends ConnectDB<Pitch, Integer> {

    public ObservableList<Pitch> fieldsObservableList = FXCollections.observableArrayList();
    public ObservableList<Pitch> availableFields = FXCollections.observableArrayList();
    public ObservableList<Pitch> rentingFieldsList = FXCollections.observableArrayList();
    public ObservableList<Pitch> bookingFieldsList = FXCollections.observableArrayList();

    public PitchDAO(Time from, Time to) {
        updateLists(from, to);
    }

    public PitchDAO() {
    }

    public void updateLists(Time from, Time to) {
        String sql = "UPDATE sanbong SET available = 1";
        executeSQL(sql);

        BookingDAO bkDAO = new BookingDAO();
        bkDAO.getAll();
        ObservableList<String> idpBookingList;
        idpBookingList = bkDAO.getAll_idpBookingToDay(from, to);
        if (!idpBookingList.isEmpty()) {
            String idpBookedList = idpBookingList.toString();
            idpBookedList = idpBookedList.replace("[", "(").replace("]", ")");

            sql = "UPDATE sanbong SET available = 3 WHERE idp IN " + idpBookedList;
            executeSQL(sql);
        }

        if (!bkDAO.getAll_idpBookingComplete_ToDay(from, to).isEmpty()) {
            String idpBookedList = bkDAO.getAll_idpBookingComplete_ToDay(from, to).toString();
            idpBookedList = idpBookedList.replace("[", "(").replace("]", ")");

            sql = "UPDATE sanbong SET available = 2 WHERE idp IN " + idpBookedList;
            executeSQL(sql);
        }
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
                fieldsObservableList.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return fieldsObservableList;
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
                fieldsObservableList.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return fieldsObservableList;
    }

    public ObservableList<Pitch> getByAvailable(int available) {

        Connection cn = getConnection();
        String query = "SELECT sanbong.*, cat_san.size, cat_san.price "
                + " FROM  sanbong"
                + " INNER JOIN"
                + " cat_san on sanbong.idcp = cat_san.idcp"
                + " WHERE sanbong.available =" + available;
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
                fieldsObservableList.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return fieldsObservableList;
    }

    //xem tinh trang san la (1,2,3): 1. trống, 2 khách đang thue, 3 sân co khach đặt
    public int getAvailableByID(int id) {
        for (Pitch f : fieldsObservableList) {
            if (f.getIdp() == id) {
                return f.getAvailable();
            }
        }
        return 0;
    }

    public int getPriceByID(int id) {
        for (Pitch f : fieldsObservableList) {
            if (f.getIdp() == id) {
                return f.getPrice();
            }
        }
        return 0;
    }

    public void UpdateAvailable(int idp, int available) {
        //available: 1. trống, 2 khách đang thue, 3 sân co khach đặt
        String sql = "UPDATE sanbong set available = " + available + " WHERE idp = " + idp;
        System.out.println("PitchDAO: updated Vailable " + available + "for " + idp);
        executeSQL(sql);
    }
}
