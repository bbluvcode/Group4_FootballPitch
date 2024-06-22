/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.PaymentBill;
import Entities.Service;
import java.sql.Connection;
import java.sql.Date;
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
public class PaymentBillDAO extends ConnectDB<PaymentBill, Integer> {

    ObservableList<PaymentBill> pbObservableList = FXCollections.observableArrayList();
    ObservableList<Service> serObservableList =FXCollections.observableArrayList();
    ObservableList<Service> serSell_ObservableList =FXCollections.observableArrayList();
    ObservableList<Service> serRent_ObservableList =FXCollections.observableArrayList();

    @Override
    public void Update(Integer id, PaymentBill t) {
        int idb = t.getIdb();
        String idu = t.getIdu();
        int idp = t.getIdp();
        String idk = t.getIdk();
        Time time_start = t.getTime_start();
        Time time_end = t.getTime_end();
        int hrs_used = t.getHrs_used();
        Date pay_date = t.getPay_date();
        int deposit = t.getDeposit();
        int tt_booking = t.getTt_booking();
        int tt_service = t.getTt_service();
        int tt_payment = t.getTt_payment();
        boolean comp = t.isComp();
        String sql = "UPDATE payments SET idu  = '" + idu + "'  , idp  = " + idp + "  , idk  = '" + idk + "'  , time_start  =  '" + time_start + "'  , time_end  = '" + time_end + "'  , hrs_used  = " + hrs_used + "  , pay_date  = '" + pay_date + "'  , deposit  = " + deposit + "  , tt_booking  = " + tt_booking + "  , tt_service  = " + tt_service + "  , tt_payment  = " + tt_payment + "  , completed  = " + comp + "WHERE idb = " + idb;
        try {
            Statement st = getConnection().createStatement();
            executeSQL(sql);
            System.out.println("Payment Bill UPDATED successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(PaymentBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Insert(PaymentBill t) {
        int idb = t.getIdb();
        String idu = t.getIdu();
        int idp = t.getIdp();
        String idk = t.getIdk();
        Time time_start = t.getTime_start();
        Time time_end = t.getTime_end();
        int hrs_used = t.getHrs_used();
        Date pay_date = t.getPay_date();
        int deposit = t.getDeposit();
        int tt_booking = t.getTt_booking();
        int tt_service = t.getTt_service();
        int tt_payment = t.getTt_payment();
        boolean comp = t.isComp();
        String sql = "INSERT INTO payments (idb, idu, idp, idk, time_start, time_end, hrs_used, pay_date, deposit, tt_booking, tt_service, tt_payment, completed) VALUES (" + idb + ", '" + idu + "', " + idp + ", '" + idk + "', GETDATE(), '" + time_end + "', " + hrs_used + ", '" + pay_date + "', " + deposit + ", " + tt_booking + ", " + tt_service + ", " + tt_payment + ", " + comp + ")";

        try {
            Statement st = getConnection().createStatement();
            executeSQL(sql);
            System.out.println("Payment Bill CREATED successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(PaymentBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Delete(Integer id) {
        String sql = "DELETE payments WHERE id = " + id;
        try {
            Statement st = getConnection().createStatement();
            executeSQL(sql);
            System.out.println("Payment Bill DELETED successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(PaymentBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public ObservableList<PaymentBill> getAll() {
        Connection cn = getConnection();
        String query = "SELECT payments.*, khachhang.name AS khachhang_name, sanbong.name AS sanbong_name, qluser.name AS qluser_name FROM qluser INNER JOIN (sanbong INNER JOIN (khachhang INNER JOIN payments ON khachhang.[idk] = payments.[idk]) ON sanbong.[idp] = payments.[idp]) ON qluser.[idu] = payments.[idu]";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int idb = rs.getInt("idb");
                String idu = rs.getString("idu");
                int idp = rs.getInt("idp");
                String idk = rs.getString("idk");
                Time time_start = rs.getTime("time_start");
                Time time_end = rs.getTime("time_end");
                int hrs_used = rs.getInt("hrs_used");
                Date pay_date = rs.getDate("pay_date");
                int deposit = rs.getInt("deposit");
                int tt_booking = rs.getInt("tt_booking");
                int tt_service = rs.getInt("tt_service");
                int tt_payment = rs.getInt("tt_payment");
                boolean comp = rs.getBoolean("completed");
                String khachhang_name = rs.getString("khachhang_name");
                String qluser_name = rs.getString("qluser_name");
                String sanbong_name = rs.getString("sanbong_name");

                PaymentBill pb = new PaymentBill(idb, idu, idp, idk, time_start, time_end, hrs_used, pay_date, deposit, tt_booking, tt_service, tt_payment, comp, khachhang_name, qluser_name, sanbong_name);
                pbObservableList.add(pb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pbObservableList;
    }

    public void UpdatePaymentCompleted(int idPaymentBill, boolean Completed) {
        String sql = "UPDATE payments SET completed = " + Completed + " WHERE idb = " + idPaymentBill;
        try {
            Statement st = getConnection().createStatement();
            executeSQL(sql);
            System.out.println("Update Payment Completed successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(PaymentBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Service> getAllSerVice(int idPaymentBill) {
        getAll_RentService(idPaymentBill);
        getAll_SellService(idPaymentBill);
        return serObservableList;
    }

    public ObservableList<Service> getAll_SellService(int idPaymentBill) {
        String query = "SELECT hd_ser_sell.idb, hd_ser_sell.idss, hd_ser_sell.qty, ser_sell.name, ser_sell.price, ser_sell.img, ser_sell.qoh, cat_ser.idc, cat_ser.type FROM (cat_ser INNER JOIN ser_sell ON cat_ser.[idc] = ser_sell.[idc]) INNER JOIN hd_ser_sell ON ser_sell.[idss] = hd_ser_sell.[idss] WHERE hd_ser_sell.idss =" + idPaymentBill;
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            Service s;

            while (rs.next()) {
                int ids = rs.getInt("idss");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String img = rs.getString("img");
                int qoh = rs.getInt("qoh");
                int idc = rs.getInt("idc");
                String type = rs.getString("type");

                s = new Service(ids, name, price, img, qoh, idc, type);
                serSell_ObservableList.add(s);
                serObservableList.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymentBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serSell_ObservableList;
    }

    public ObservableList<Service> getAll_RentService(int idPaymentBill) {
        String query = "SELECT hd_ser_rent.idb, hd_ser_rent.idsr, hd_ser_rent.qty, ser_rent.name, ser_rent.price, ser_rent.img, ser_rent.qoh, cat_ser.idc, cat_ser.type FROM (cat_ser INNER JOIN ser_rent ON cat_ser.[idc] = ser_rent.[idc]) INNER JOIN hd_ser_rent ON ser_rent.[idsr] = hd_ser_rent.[idsr] WHERE hd_ser_rent.idsr = " + idPaymentBill;

        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            Service s;

            while (rs.next()) {
                int ids = rs.getInt("idsr");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String img = rs.getString("img");
                int qoh = rs.getInt("qoh");
                int idc = rs.getInt("idc");
                String type = rs.getString("type");

                s = new Service(ids, name, price, img, qoh, idc, type);
                serRent_ObservableList.add(s);
                serObservableList.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymentBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serSell_ObservableList;
    }

    //làm thêm cái tìm kiếm theo ngày
    public Optional<PaymentBill> SearchByPitch(int idp) {
        for (PaymentBill pm : pbObservableList) {
            if (pm.getIdp() == idp) {
                return Optional.of(pm);
            }
        }
        return Optional.empty();
    }

    public void UpdateTimeStart (int idPaymentBill) {
        String sql = "UPDATE payments set time_start = CAST(GETDATE() as TIME), stt = 2 WHERE idb = " + idPaymentBill;
        System.out.println("START BUTTON: " + sql);
        executeSQL(sql);
    }
}
