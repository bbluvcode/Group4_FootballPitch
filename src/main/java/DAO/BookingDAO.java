/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.Booking;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ADMIN
 */
public class BookingDAO extends ConnectDB<Booking, Integer> {

    ObservableList<Booking> bkObservableList = FXCollections.observableArrayList();

    @Override
    public void Update(Integer id, Booking b) {
        int idb = b.getIdb();
        String idu = b.getIdu();
        int idp = b.getIdp();
        String idk = b.getIdk();
        Time time = b.getTime_book();
        int hrs = b.getHrs();
        int deposit = b.getDep();
        String sql = "UPDATE payments SET idu = " + idu + ", idp = " + idp + ", idk = " + idk + ",time = " + time + ", hrs = " + hrs + ", deposit = " + deposit + " WHERE idb = id";
        executeSQL(sql);
        System.out.println("Booking UPDATED Successfully!");
    }

    @Override
    public void Insert(Booking b) {
        String idu = b.getIdu();
        int idp = b.getIdp();
        String idk = b.getIdk();
        Time time = b.getTime_book();
        int hrs = b.getHrs();
        int deposit = b.getDep();
        int stt = b.getStt();
        String sql = "INSERT INTO payments (idu, idp, idk, time, hrs, deposit, stt) VALUES (" + idu + ", " + idp + ", " + idk + "," + time + ", " + hrs + ", " + deposit + ", 1 )";
        executeSQL(sql);
        System.out.println("Booking INSERTED Successfully!");
    }

    @Override
    public void Delete(Integer idb) {
        String sql = "DELETE payments WHERE idb = " + idb;
        executeSQL(sql);
        System.out.println("Booking DELETED Successfully!");
    }

    @Override
    public ObservableList<Booking> getAll() {
        Connection cn = getConnection();
        String sql = "SELECT payments.*, khachhang.name AS khachhang_name, sanbong.name AS sanbong_name, qluser.name AS qluser_name "
                + "FROM qluser INNER JOIN (sanbong INNER JOIN (khachhang INNER JOIN payments ON khachhang.[idk] = payments.[idk]) ON sanbong.[idp] = payments.[idp]) ON qluser.[idu] = payments.[idu] WHERE pay_date = CAST(GETDATE() AS DATE)";
        try {System.out.println(sql);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int idb = rs.getInt("idb");
                String idu = rs.getString("idu");
                int idp = rs.getInt("idp");
                String idk = rs.getString("idk");
                Time time_book = rs.getTime("time_book");
                int hrs = rs.getInt("hrs");
                int deposit = rs.getInt("deposit");
                int stt = rs.getInt("stt");
                String khachhang_name = rs.getString("khachhang_name");
                String qluser_name = rs.getString("qluser_name");
                String sanbong_name = rs.getString("sanbong_name");

                Booking b = new Booking(idb, idu, idp, idk, time_book, hrs, deposit, stt, khachhang_name, qluser_name, sanbong_name);
                bkObservableList.add(b);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bkObservableList;
    }

    public void UpdateSTT(Integer idb, int stt) { //update status
        String sql = "UPDATE payments SET stt = " + " WHERE idb = idb";
        executeSQL(sql);
        System.out.println("Booking Status UPDATED Successfully!");
    }

    public Optional<Booking> getBookingByPitch(int idp) {
        for (Booking bk : bkObservableList) {
            if (bk.getIdp() == idp) {
                return Optional.of(bk);
            }
        }
        return Optional.empty();
    }
    // System.out.println("Search");
//        Optional<User> user = uD.read(1);
//        if (user.isPresent()) {
//            System.out.println(user.get());
//        } else {
//            System.out.println("User not found! ");
//        }
}
