/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group4_project;

import java.sql.*;

/**
 *
 * @author User
 */
public class ConnectDB {
    public Connection cn;
    public Connection getConnect() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=qlsanbong;encrypt=true;trustServerCertificate=true;";
        String username = "sa";
        String pass = "123";

        try {
            //load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //connect to DB
            cn = DriverManager.getConnection(url, username, pass);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Cannot Connect !");
            System.out.println(ex.getMessage());
        }
        return cn;
    }
    public void closeConnection() {
        if (cn != null) {
            try {
                cn.close();
                cn = null;
                System.out.println("Connection closed successfully !");
            } catch (SQLException ex) {
                System.out.println("Error closing connection: " + ex.getMessage());
            }
        }
    }
}
