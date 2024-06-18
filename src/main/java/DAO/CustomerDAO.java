/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Admin
 */
public class CustomerDAO extends ConnectDB<Customer, String> {

    ArrayList<Customer> CusList = new ArrayList<>();

    @Override
    public void Update(String id, Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Insert(Customer t) {
        String idk = t.getIdk();
        String name = t.getName();
        String phone = t.getPhone();
        int point = t.getPoint();
//        String mail = t.getMail();
        String sql = "INSERT INTO customer VALUES('" + idk + "','" + name + "','" + phone + "'," + point + ")";
        executeSQL(sql);
    }

    @Override
    public void Delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Customer> getAll() {
        String query = "SELECT * FROM khachhang";

        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            Customer c;
            while (rs.next()) {
                String idk = rs.getString("idk");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                int point = rs.getInt("point");
                String mail = "";

                c = new Customer(idk, name, phone, point, mail);
                CusList.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CusList;
    }

}
