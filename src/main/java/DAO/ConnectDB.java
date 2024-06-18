/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public abstract class ConnectDB<Entity, idType> {

    public Connection cn;

    public Connection getConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=qlsanbong;encrypt=true;trustServerCertificate=true;";
        String username = "sa";
        String pass = "123";

        try {
            //load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //connect to db
            cn = DriverManager.getConnection(url, username, pass);
            
            System.out.println("Connect DB successfully!");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } catch (SQLException ex) {
            System.err.println("Cannot connect");
            System.err.println(ex.getMessage());
        }
        return cn;
    }

    public abstract void Update(idType id, Entity t);

    public abstract void Insert(Entity t);

    public abstract void Delete(idType id);

    public abstract List<Entity> getAll();

    public void executeSQL(String query) {
        Connection cn = getConnection();

        Statement st;
        try {
            st = cn.createStatement();
            st.executeUpdate(query);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
