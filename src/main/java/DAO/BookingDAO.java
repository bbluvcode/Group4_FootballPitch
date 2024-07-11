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

import java.time.LocalTime;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author ADMIN
 */
public class BookingDAO extends ConnectDB<Booking, Integer> {

    ObservableList<Booking> bkObservableList = FXCollections.observableArrayList();

    @Override
    public void Update(Integer id, Booking b) {
        int idb = id;
        String idu = b.getIdu();
        int idp = b.getIdp();
        String idk = b.getIdk();
        Time time = b.getTime_book();
        int hrs = b.getHrs();
        int deposit = b.getDep();
        String sql = "UPDATE payments SET idp = " + idp + ", idk = '" + idk + "', time_book = '" + time + "', hrs = " + hrs + ", deposit = " + deposit + " WHERE idb = " + idb;
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
        String sql = "INSERT INTO payments (idu, idp, idk, time_book, hrs, deposit, stt, pay_date) VALUES ('" + idu + "', " + idp + ", '" + idk + "', '" + time + "', " + hrs + ", " + deposit + ", 1 , CAST(GETDATE() AS DATE))";
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
        try {
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
        String sql = "UPDATE payments SET stt = " + stt + " , completed = 1 WHERE idb = " + idb;
        executeSQL(sql);
        System.out.println("Booking Status UPDATED Successfully!");
    }

    public Optional<Booking> getBookingByPitch(int idp, int stt) {
        for (Booking bk : bkObservableList) {
            if (bk.getIdp() == idp && bk.getStt() == stt) {
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

    public ObservableList<String> getAll_idpBookingToDay(Time from, Time to) {
        ObservableList<String> idpBookingToDay = FXCollections.observableArrayList();
        Connection cn = getConnection();
        int hrsBooked = 1;
        if (from == null) {
            LocalTime timeNow = LocalTime.now();
            from = Time.valueOf(timeNow);
        }
        if (to != null) {
            hrsBooked = to.toLocalTime().getHour() - from.toLocalTime().getHour();
        } else {
            to = Time.valueOf(from.toLocalTime().plusHours(hrsBooked));
        }

        Time from2 = Time.valueOf(from.toLocalTime().minusHours(hrsBooked));
        String sql = "SELECT idp FROM payments" +
                " WHERE pay_date = CAST(GETDATE() AS DATE) AND time_start IS NULL AND completed IS NULL"
                + " AND ((time_book >= '" + from + "' AND time_book < '" + to + "') OR (time_book > '" + from2 + "' AND time_book < '" + from + "' AND hrs = " + hrsBooked + "))";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String idp = rs.getString("idp");
                idpBookingToDay.add(idp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idpBookingToDay;
    }

    public ObservableList<Booking> getAll_infoBookingForPitch(Time from, Time to) {
        ObservableList<Booking> infoBookingForPitch = FXCollections.observableArrayList();

        Connection cn = getConnection();
        int hrsBooked = 1;
        if (from == null) {
            LocalTime timeNow = LocalTime.now();
            from = Time.valueOf(timeNow);
        }
        if (to != null) {
            hrsBooked = to.toLocalTime().getHour() - from.toLocalTime().getHour();
        } else {
            to = Time.valueOf(from.toLocalTime().plusHours(hrsBooked));
        }
        Time from2 = Time.valueOf(from.toLocalTime().minusHours(hrsBooked));
        String sql = "SELECT payments.*, khachhang.name AS khachhang_name, sanbong.name AS sanbong_name, qluser.name AS qluser_name "
                + "FROM qluser INNER JOIN (sanbong INNER JOIN (khachhang INNER JOIN payments ON khachhang.[idk] = payments.[idk]) ON sanbong.[idp] = payments.[idp]) ON qluser.[idu] = payments.[idu] "
                + " WHERE pay_date = CAST(GETDATE() AS DATE) AND time_start IS NULL AND completed IS NULL"
                + " AND ((time_book >= '" + from + "' AND time_book < '" + to + "') OR (time_book > '" + from2 + "' AND time_book < '" + from + "' AND hrs = " + hrsBooked + "))";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Booking b;
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

                b = new Booking(idb, idu, idp, idk, time_book, hrs, deposit, stt, khachhang_name, qluser_name, sanbong_name);
                infoBookingForPitch.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return infoBookingForPitch;
    }

    public ObservableList<String> getAll_idpBookingComplete_ToDay(Time from, Time to) {
        ObservableList<String> idpBookingToDay = FXCollections.observableArrayList();

        Connection cn = getConnection();

        int hrsBooked = 1;
        if (from == null) {
            LocalTime timeNow = LocalTime.now();
            from = Time.valueOf(timeNow);
        }
        if (to != null) {
            hrsBooked = to.toLocalTime().getHour() - from.toLocalTime().getHour();
        } else {
            to = Time.valueOf(from.toLocalTime().plusHours(hrsBooked));
        }

        Time from2 = Time.valueOf(from.toLocalTime().minusHours(hrsBooked));
        String sql = "SELECT idp FROM payments" +
                " WHERE pay_date = CAST(GETDATE() AS DATE)"
                + " AND time_start IS NOT NULL AND time_end IS NULL AND completed IS NULL"
                + " AND ((time_start >= '" + from + "' AND time_start < '" + to + "') OR (time_start > '" + from2 + "' AND time_start < '" + from + "' AND hrs = " + hrsBooked + "))";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String idp = rs.getString("idp");
                idpBookingToDay.add(idp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idpBookingToDay;
    }

    public ObservableList<Booking> getAll_infoBooking_COMPLETE_ForPitch(Time from, Time to) {
        ObservableList<Booking> infoBookingForPitch = FXCollections.observableArrayList();

        Connection cn = getConnection();




        int hrsBooked = 1;
        if (from == null) {
            LocalTime timeNow = LocalTime.now();
            from = Time.valueOf(timeNow);
        }
        if (to != null) {
            hrsBooked = to.toLocalTime().getHour() - from.toLocalTime().getHour();
        } else {
            to = Time.valueOf(from.toLocalTime().plusHours(hrsBooked));
        }

        Time from2 = Time.valueOf(from.toLocalTime().minusHours(hrsBooked));

        String sql = "SELECT payments.*, khachhang.name AS khachhang_name, sanbong.name AS sanbong_name, qluser.name AS qluser_name " +
                "FROM qluser INNER JOIN (sanbong INNER JOIN (khachhang INNER JOIN payments ON khachhang.[idk] = payments.[idk]) ON sanbong.[idp] = payments.[idp]) ON qluser.[idu] = payments.[idu]" +
                " WHERE pay_date = CAST(GETDATE() AS DATE) AND time_start IS NOT NULL AND time_end IS NULL  AND completed IS NULL"
                + " AND ((time_start >= '" + from + "' AND time_start < '" + to + "') OR (time_start > '" + from2 + "' AND time_start < '" + from + "' AND hrs = " + hrsBooked + "))";


        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Booking b;
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
                Time time_start = rs.getTime("time_start");

                b = new Booking(idb, idu, idp, idk, time_book, hrs, deposit, stt, khachhang_name, qluser_name, sanbong_name, time_start);
                infoBookingForPitch.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return infoBookingForPitch;
    }

    //get by Time
    public ObservableList<String> getAll_idpBookingToDay_byTime(Time cbotimeEnd, Time cbotimeBook) {
        ObservableList<String> idpBookingToDay_byTime = FXCollections.observableArrayList();

        return idpBookingToDay_byTime;
    }

    public ObservableList<String> getAll_idpBookingComplete_ToDay_byTime(Time timeStart, Time timeBook, int hrsBook) {
        ObservableList<String> idpBookingToDay = FXCollections.observableArrayList();

        Connection cn = getConnection();
        String sql = "SELECT * FROM payments WHERE pay_date = CAST(GETDATE() AS DATE) AND time_start IS NOT NULL AND time_end IS NULL  AND completed IS NULL";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String idp = rs.getString("idp");
                idpBookingToDay.add(idp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idpBookingToDay;
    }

}
