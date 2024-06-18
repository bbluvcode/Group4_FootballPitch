/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ServiceDAO extends ConnectDB<Service, Integer> {

    ArrayList<Service> serList = new ArrayList<>();
    ArrayList<Service> serSell_List = new ArrayList<>();
    ArrayList<Service> serRent_List = new ArrayList<>();

    @Override
    public void Update(Integer id, Service s) {
        int ids = s.getIds();
        String name = s.getName();
        int price = s.getPrice();
        String img = s.getImg();
        int qoh = s.getQoh();
        int idc = s.getIdc();
        String type = s.getType();
        String name_table = idc == 3 ? "hd_ser_rent" : "hd_ser_sell";
        String id_table = idc == 3 ? "idsr" : "idss";
        String sql = "UPDATE " + name_table + " SET name = '" + name + "', price = " + price + ", img = '" + img + "', qoh =" + qoh + ", idc = " + idc + " WHERE " + id_table + " = " + ids;
        executeSQL(sql);
        System.out.println("Update SERVICE infor sucessfully");
    }

    @Override
    public void Insert(Service t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Service> getAll() {
        getAll_RentService();
        getAll_SellService();
        return serList;
    }

    public List<Service> getAll_SellService() {
        String query = "SELECT ser_sell.*, cat_ser.type FROM ser_sell INNER JOIN cat_ser ON ser_sell.idc = cat_ser.idc";
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
                serSell_List.add(s);
                serList.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymentBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serSell_List;
    }

    public List<Service> getAll_RentService() {
        String query = "SELECT ser_rent.*, cat_ser.type FROM ser_rent INNER JOIN cat_ser ON ser_rent.idc = cat_ser.idc";
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
                serRent_List.add(s);
                serList.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymentBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serSell_List;
    }

}
