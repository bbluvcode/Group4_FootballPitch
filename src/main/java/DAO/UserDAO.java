/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author ADMIN
 */
public class UserDAO extends ConnectDB<User, String> {

    ObservableList<User> UserObservableList = FXCollections.observableArrayList();
    ObservableList<String> UserID_String_List = FXCollections.observableArrayList();

    @Override
    public void Update(String idu, User u) {
        Connection cn = getConnection();

        String pw = u.getPw();
        String name = u.getName();
        Date birthday = u.getBirthday();
        boolean gender = u.isGender();
        String phone = u.getPhone();
        String img = u.getImg();

        String sql = "UPDATE qluser SET pw = '" + pw + "' , name = '" + name + "', birthday = '" + birthday + "', gender = '" + gender + "', phone = '" + phone + "', img = '" + img + "' WHERE idu = '" + idu + "'";
        executeSQL(sql);
        System.out.println("User Information Success Updated!");
    }

    @Override
    public void Insert(User t) {

    }

    @Override
    public void Delete(String id) {

    }

    @Override
    public ObservableList<User> getAll() {
        Connection cn = getConnection();
        String sql = "SELECT qluser.*, user_type.type FROM qluser INNER JOIN user_type ON qluser.[idt]=user_type.[idt]";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String idu = rs.getString("idu");
                String pw = rs.getString("pw");
                String name = rs.getString("name");
                Date birthday = rs.getDate("birthday");
                boolean gender = rs.getBoolean("gender");
                String phone = rs.getString("phone");
                String img = rs.getString("img");
                int idt = rs.getInt("idt");
                String type = rs.getString("type");

                User u = new User(idu, pw, name, birthday, gender, phone, img, idt, type);
                UserObservableList.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return UserObservableList;
    }

    public ObservableList<String> getAll_ID_User() {
        Connection cn = getConnection();
        String sql = "SELECT qluser.*, user_type.type FROM qluser INNER JOIN user_type ON qluser.[idt]=user_type.[idt]";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String idu = rs.getString("idu");

                UserID_String_List.add(idu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return UserID_String_List;
    }

    public Optional<User> Search(String id) {
        for (User u : UserObservableList) {
            if (u.getIdu().equals(id)) {
                return Optional.of(u);
            }
        }
        return Optional.empty();

    }

}
