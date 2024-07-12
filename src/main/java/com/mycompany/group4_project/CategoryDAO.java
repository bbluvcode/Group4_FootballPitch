/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group4_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class CategoryDAO {

    ConnectDB con = new ConnectDB();
    Connection cn = con.getConnect();

    public boolean mailExistsInQLUser(String email) {
        String query = "SELECT COUNT(*) FROM qluser WHERE mail = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ObservableList<String> getProductsByCategory(int idc) {
        ObservableList<String> productList = FXCollections.observableArrayList();
        String query = "SELECT name FROM ser_sell WHERE idc = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, idc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String product = rs.getString("name");
                productList.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return productList;
    }

    public ObservableList<String> getProductsIsFood() {
        return getProductsByCategory(1);
    }

    public ObservableList<String> getProductsIsDrink() {
        return getProductsByCategory(2);
    }

    public ObservableList<String> getProductsIsAcess() {
        ObservableList<String> productList = FXCollections.observableArrayList();
        String query = "SELECT name FROM ser_rent WHERE idc = 3";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String product = rs.getString("name");
                productList.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return productList;
    }

    public int getQuantityInSerSell(String name) {
        int quantity = 0;
        String query = "SELECT qoh FROM ser_sell WHERE name = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt("qoh");
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return quantity;
    }

    public int getQuantityInSerRent(String name) {
        int quantity = 0;
        String query = "SELECT qoh FROM ser_rent WHERE name = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt("qoh");
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return quantity;
    }

    public ObservableList<String> getNameEmployees() {
        ObservableList<String> nameEmpList = FXCollections.observableArrayList();
        String query = "SELECT name FROM qluser";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                nameEmpList.add(name);
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return nameEmpList;
    }
    public ObservableList<String> getTypeOfService() {
        ObservableList<String> list = FXCollections.observableArrayList();
        String query = "SELECT type FROM cat_ser";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String type = rs.getString("type");
                list.add(type);
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return list;
    }

    public ObservableList<String> getNameCustomers() {
        ObservableList<String> nameCusList = FXCollections.observableArrayList();
        String query = "SELECT name FROM khachhang";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                nameCusList.add(name);
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return nameCusList;
    }

    public ObservableList<String> getNamePitchs() {
        ObservableList<String> pList = FXCollections.observableArrayList();
        String query = "SELECT name FROM sanbong";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                pList.add(name);
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return pList;
    }

    public String getIDInEmp(String name) {
        String ID = null;
        String query = "SELECT idu FROM qluser WHERE name = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ID = rs.getString("idu");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return ID;
    }

    public String getIDInCustomer(String name) {
        String ID = null;
        String query = "SELECT idk FROM khachhang WHERE name = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ID = rs.getString("idk");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return ID;
    }

    public int getIDInPitch(String name) {
        int ID = 0;
        String query = "SELECT idp FROM sanbong WHERE name = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ID = rs.getInt("idp");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return ID;
    }

    public int getPriceOfPitch(String name) {
        int price = 0;
        String query = "SELECT price FROM cat_san c JOIN sanbong s ON c.idcp = s.idcp WHERE s.name = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                price = rs.getInt("price");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return price;
    }

}
