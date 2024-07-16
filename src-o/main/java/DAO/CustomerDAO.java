/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Admin
 */
public class CustomerDAO extends ConnectDB<Customer, String> {

    ObservableList<Customer> CusList = FXCollections.observableArrayList();
    ObservableList<String> CusID_String_List = FXCollections.observableArrayList();

    @Override
    public void Update(String id, Customer t) {
        String idk = t.getIdk();
        String name = t.getName();
        String phone = t.getPhone();
        int point = t.getPoint();
        String mail = t.getMail();
        String sql = "UPDATE khachhang SET name='" + name + "',phone='" + phone + "',mail='" + mail + "' WHERE idk='" + idk + "'";
        executeSQL(sql);

    }

    @Override
    public void Insert(Customer t) {
        String idk = t.getIdk();
        String name = t.getName();
        String phone = t.getPhone();
        int point = t.getPoint();
        String mail = t.getMail();
        String sql = "INSERT INTO khachhang VALUES('" + idk + "','" + name + "','" + phone + "'," + point + " , '" + mail + "' )";
        executeSQL(sql);
    }

    @Override
    public void Delete(String id) {
        String sql = "DELETE FROM khachhang WHERE idk='" + id + "'";
        executeSQL(sql);
    }

    @Override
    public ObservableList<Customer> getAll() {
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

    public ObservableList<String> getAll_ID_Cus() {
        Connection cn = getConnection();
        String sql = "SELECT * FROM khachhang";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String idk = rs.getString("idk");

                CusID_String_List.add(idk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CusID_String_List;
    }
}
