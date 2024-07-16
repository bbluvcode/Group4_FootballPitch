/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ADMIN
 */
public class ChartDAO extends ConnectDB<String, Double> {

    @Override
    public void Update(Double id, String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Insert(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Delete(Double id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ObservableList<String> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ObservableList<PieChart.Data> ServiceRevenues(String condition) {
        ObservableList<PieChart.Data> serRevenue = FXCollections.observableArrayList();
        String sql = "WITH TotalRevenue AS (\n" +
                "    SELECT SUM(revenue) AS total_revenue\n" +
                "    FROM (\n" +
                "        SELECT (ser_sell.price * hd_ser_sell.qty) AS revenue\n" +
                "        FROM ser_sell\n" +
                "        JOIN hd_ser_sell ON ser_sell.idss = hd_ser_sell.idss\n" +
                "        JOIN payments ON hd_ser_sell.idb = payments.idb\n" +
                condition +
                "        UNION ALL\n" +
                "        SELECT (ser_rent.price * hd_ser_rent.qty) AS revenue\n" +
                "        FROM ser_rent\n" +
                "        JOIN hd_ser_rent ON ser_rent.idsr = hd_ser_rent.idsr\n" +
                "        JOIN payments ON hd_ser_rent.idb = payments.idb\n" +
                condition +
                "    ) AS combined_revenues\n" +
                "),\n" +
                "RevenueByType AS (\n" +
                "    SELECT type, SUM(revenue) AS total_revenue_by_type\n" +
                "    FROM (\n" +
                "        SELECT cat_ser.type AS type, (ser_sell.price * hd_ser_sell.qty) AS revenue\n" +
                "        FROM ser_sell\n" +
                "        JOIN cat_ser ON ser_sell.idc = cat_ser.idc\n" +
                "        JOIN hd_ser_sell ON ser_sell.idss = hd_ser_sell.idss\n" +
                "        JOIN payments ON hd_ser_sell.idb = payments.idb\n" +
                condition +
                "        UNION ALL\n" +
                "        SELECT cat_ser.type AS type, (ser_rent.price * hd_ser_rent.qty) AS revenue\n" +
                "        FROM ser_rent\n" +
                "        JOIN cat_ser ON ser_rent.idc = cat_ser.idc\n" +
                "        JOIN hd_ser_rent ON ser_rent.idsr = hd_ser_rent.idsr\n" +
                "        JOIN payments ON hd_ser_rent.idb = payments.idb\n" +
                condition +
                "    ) AS combined_revenues\n" +
                "    GROUP BY type\n" +
                ")\n" +
                "SELECT TOP 5\n" +
                "    type,\n" +
                "    total_revenue_by_type,\n" +
                "    ROUND((CAST(total_revenue_by_type AS FLOAT) / CAST(total_revenue AS FLOAT)) * 100,2) AS percentage\n" +
                "FROM RevenueByType, TotalRevenue\n" +
                "ORDER BY total_revenue_by_type DESC;";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                PieChart.Data c = new PieChart.Data(rs.getString("type") + "\n" + rs.getDouble("percentage") + "%", rs.getDouble("total_revenue_by_type"));
                serRevenue.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return serRevenue;
    }

    public ObservableList<PieChart.Data> barChart_Top5PitchCategory(String condition) {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();

        String sql = "WITH RevenueBySize AS (\n" +
                "    SELECT cat_san.size AS type_pitch, SUM(payments.tt_booking) AS total_rental\n" +
                "    FROM cat_san\n" +
                "    JOIN sanbong ON cat_san.idcp = sanbong.idcp\n" +
                "    JOIN payments ON sanbong.idp = payments.idp\n" +
                "    " + condition +
                "    GROUP BY cat_san.size\n" +
                "),\n" +
                "TotalRevenue AS (\n" +
                "    SELECT SUM(payments.tt_booking) AS total_revenue\n" +
                "    FROM sanbong\n" +
                "    JOIN payments ON sanbong.idp = payments.idp\n" +
                condition +
                ")\n" +
                "SELECT \n" +
                "    type_pitch,\n" +
                "    total_rental,\n" +
                "    ROUND(total_rental * 100.0 / total_revenue, 2) AS percentage_of_total\n" +
                "FROM \n" +
                "    RevenueBySize, TotalRevenue\n" +
                "ORDER BY \n" +
                "    type_pitch ASC;\n";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                PieChart.Data c = new PieChart.Data(rs.getString("type_pitch") + "\n" + rs.getDouble("percentage_of_total") + "%", rs.getDouble("total_rental"));
                data.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }

    public XYChart.Series barChart_Top5Service(String condition) {
        XYChart.Series series = new XYChart.Series();
        String sql = "WITH TotalRevenue AS (\n" +
                "    SELECT SUM(revenue) AS total_revenue\n" +
                "    FROM (\n" +
                "        SELECT (ser_sell.price * hd_ser_sell.qty) AS revenue\n" +
                "        FROM ser_sell\n" +
                "        JOIN hd_ser_sell ON ser_sell.idss = hd_ser_sell.idss\n" +
                "        JOIN payments ON hd_ser_sell.idb = payments.idb\n" +
                condition +
                "        UNION ALL\n" +
                "        SELECT (ser_rent.price * hd_ser_rent.qty) AS revenue\n" +
                "        FROM ser_rent\n" +
                "        JOIN hd_ser_rent ON ser_rent.idsr = hd_ser_rent.idsr\n" +
                "        JOIN payments ON hd_ser_rent.idb = payments.idb\n" +
                condition +
                "    ) AS combined_revenues\n" +
                "),\n" +
                "RevenueByService AS (\n" +
                "    SELECT name, SUM(revenue) AS total_revenue_by_service\n" +
                "    FROM (\n" +
                "        SELECT ser_sell.name AS name, (ser_sell.price * hd_ser_sell.qty) AS revenue\n" +
                "        FROM ser_sell\n" +
                "        JOIN hd_ser_sell ON ser_sell.idss = hd_ser_sell.idss\n" +
                "        JOIN payments ON hd_ser_sell.idb = payments.idb\n" +
                condition +
                "        UNION ALL\n" +
                "        SELECT ser_rent.name AS name, (ser_rent.price * hd_ser_rent.qty) AS revenue\n" +
                "        FROM ser_rent\n" +
                "        JOIN hd_ser_rent ON ser_rent.idsr = hd_ser_rent.idsr\n" +
                "        JOIN payments ON hd_ser_rent.idb = payments.idb\n" +
                condition +
                "    ) AS combined_revenues\n" +
                "    GROUP BY name\n" +
                ")\n" +
                "SELECT TOP 5\n" +
                "    name,\n" +
                "    ROUND(total_revenue_by_service,-3)/1000 AS total_revenue_by_service\n" +
                "FROM RevenueByService\n" +
                "ORDER BY total_revenue_by_service DESC;";

        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                series.getData().add(new XYChart.Data(rs.getDouble("total_revenue_by_service"), rs.getString("name")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return series;
    }

    public ObservableList<XYChart.Series> barChart_Top3Customer(String condition) {
        ObservableList<XYChart.Series> data = FXCollections.observableArrayList();
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        series1.setName("Total payment");
        series2.setName("Total service");
        series3.setName("Total rental");

        String sql = "SELECT TOP 3\n" +
                "khachhang.idk AS makh, \n" +
                "khachhang.name AS namekh, \n" +
                "SUM(payments.tt_booking) AS tt_rental,\n" +
                "SUM(payments.tt_service) AS tt_ser,\n" +
                "SUM(payments.tt_payment) AS tt_pay\n" +
                "FROM khachhang \n" +
                "JOIN payments ON khachhang.idk = payments.idk\n" +
                condition +
                "GROUP BY khachhang.idk, khachhang.name\n" +
                "ORDER BY tt_pay DESC";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                series1.getData().add(new XYChart.Data(rs.getString("namekh") + "-" + rs.getString("makh"), rs.getDouble("tt_pay")));
                series2.getData().add(new XYChart.Data(rs.getString("namekh") + "-" + rs.getString("makh"), rs.getDouble("tt_ser")));
                series3.getData().add(new XYChart.Data(rs.getString("namekh") + "-" + rs.getString("makh"), rs.getDouble("tt_rental")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        data.add(series1);
        data.add(series2);
        data.add(series3);
        return data;
    }

    public ObservableList<XYChart.Series> lineChart(String condition) {
        ObservableList<XYChart.Series> data = FXCollections.observableArrayList();
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        series1.setName("Total payment");
        series2.setName("Total service");
        series3.setName("Total rental");

        String sql = "SELECT \n" +
                "    MONTH(payments.pay_date) AS month,\n" +
                "    SUM(payments.tt_payment) AS tt_payment,\n" +
                "    SUM(payments.tt_booking) AS t_booking,\n" +
                "    SUM(payments.tt_service) AS tt_service\n" +
                "FROM payments\n" +
                condition +
                "GROUP BY MONTH(payments.pay_date)\n" +
                "ORDER BY month;";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String monthName;
                int month = rs.getInt("month");
                switch (month) {
                    case 1:
                        monthName = "January";
                        break;
                    case 2:
                        monthName = "February";
                        break;
                    case 3:
                        monthName = "March";
                        break;
                    case 4:
                        monthName = "April";
                        break;
                    case 5:
                        monthName = "May";
                        break;
                    case 6:
                        monthName = "June";
                        break;
                    case 7:
                        monthName = "July";
                        break;
                    case 8:
                        monthName = "August";
                        break;
                    case 9:
                        monthName = "September";
                        break;
                    case 10:
                        monthName = "October";
                        break;
                    case 11:
                        monthName = "November";
                        break;
                    case 12:
                        monthName = "December";
                        break;
                    default:
                        monthName = "Invalid month";
                        break;
                }
                series1.getData().add(new XYChart.Data(monthName, rs.getDouble("tt_payment")));
                series2.getData().add(new XYChart.Data(monthName, rs.getDouble("t_booking")));
                series3.getData().add(new XYChart.Data(monthName, rs.getDouble("tt_service")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        data.add(series1);
        data.add(series2);
        data.add(series3);
        return data;
    }

    public HashMap<String, Double> getTotalRevenue(String condition) {
        Double ttRevenue, ttRental, ttSer, numberOfRental;
        HashMap<String, Double> getTT = new HashMap<>();
        String sql = "SELECT ROUND(SUM(tt_payment)/1000000,2) AS ttRevenue, ROUND(SUM(tt_booking)/1000000,2) AS ttRental, ROUND(SUM(tt_service)/1000,1) AS ttSer , Count(idb) AS numberOfRental FROM payments " + condition;
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            ttRevenue = rs.getDouble("ttRevenue");
            ttRental = rs.getDouble("ttRental");
            ttSer = rs.getDouble("ttSer");
            numberOfRental = rs.getDouble("numberOfRental");
            getTT.put("ttRevenue", ttRevenue);
            getTT.put("ttRental", ttRental);
            getTT.put("ttSer", ttSer);
            getTT.put("numberOfRental", numberOfRental);
        } catch (Exception ex) {
            System.err.println("pmDAO_totalRevenue: " + ex.getMessage());
        }
        return getTT;
    }

    public ObservableList<XYChart.Series> barChart_month_inside() {
        ObservableList<XYChart.Series> data = FXCollections.observableArrayList();
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        series1.setName("Total payment");
        series2.setName("Total service");
        series3.setName("Total rental");

        LocalDate currentDate = LocalDate.now();
        LocalDate before6MonthDate = currentDate.minusMonths(6).withDayOfMonth(1);

        String sql = "SELECT \n" +
                "    CONCAT(MONTH(payments.pay_date), '/', YEAR(payments.pay_date)) AS month,\n" +
                "    SUM(payments.tt_payment) AS tt_payment,\n" +
                "    SUM(payments.tt_booking) AS tt_booking,\n" +
                "    SUM(payments.tt_service) AS tt_service\n" +
                "FROM payments\n" +
                "WHERE payments.pay_date <= '" + currentDate +"'"+
                "  AND payments.pay_date >= '" + before6MonthDate +"'"+
                " GROUP BY MONTH(payments.pay_date), YEAR(payments.pay_date)\n" +
                "ORDER BY YEAR(payments.pay_date), MONTH(payments.pay_date);";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String monthName = rs.getString("month");

                series1.getData().add(new XYChart.Data(monthName, rs.getDouble("tt_payment")));
                series2.getData().add(new XYChart.Data(monthName, rs.getDouble("tt_booking")));
                series3.getData().add(new XYChart.Data(monthName, rs.getDouble("tt_service")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        data.add(series1);
        data.add(series2);
        data.add(series3);
        return data;
    }

    public ObservableList<XYChart.Series> barChart_monthCus_inside() {
        ObservableList<XYChart.Series> data = FXCollections.observableArrayList();
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        series1.setName("Total payment");
        series2.setName("Total service");
        series3.setName("Total rental");

        LocalDate currentDate = LocalDate.now();
        LocalDate before6MonthDate = currentDate.minusMonths(6).withDayOfMonth(1);

        String sql = "SELECT \n" +
                "    CONCAT(khachhang.name, '-', khachhang.idk) AS cus,\n" +
                "    SUM(payments.tt_payment) AS tt_payment,\n" +
                "    SUM(payments.tt_booking) AS tt_booking,\n" +
                "    SUM(payments.tt_service) AS tt_service\n" +
                "FROM payments \n" +
                "JOIN khachhang ON payments.idk = khachhang.idk\n" +
                "WHERE payments.pay_date <= '" + currentDate +"'"+
                "  AND payments.pay_date >= '" + before6MonthDate +"'"+
                "GROUP BY khachhang.name, khachhang.idk\n" +
                "ORDER BY tt_payment DESC;";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String nameCus = rs.getString("cus");

                series1.getData().add(new XYChart.Data(nameCus, rs.getDouble("tt_payment")));
                series2.getData().add(new XYChart.Data(nameCus, rs.getDouble("tt_booking")));
                series3.getData().add(new XYChart.Data(nameCus, rs.getDouble("tt_service")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        data.add(series1);
        data.add(series2);
        data.add(series3);
        return data;
    }
}
