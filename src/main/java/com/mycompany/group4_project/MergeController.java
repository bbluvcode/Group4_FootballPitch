/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.group4_project;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.ChartDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class MergeController implements Initializable {


    @FXML
    private BorderPane DashboardPage;
    @FXML
    private Button dashboard_btnSalesPerformance;
    @FXML
    private BarChart<String, Number> dashboard_barChart_Income;
    @FXML
    private ComboBox<?> dashboard_cboFilter;
    @FXML
    private Button dashboard_btnSetChart_Service;
    @FXML
    private Button dashboard_btnSetChart_customer;
    @FXML
    private Button dashboard_btnSetChart_pitch;
    @FXML
    private Label lbTotalRevenue;
    @FXML
    private Label lbServiceRevenue;
    @FXML
    private Label lbTotalRentals;
    @FXML
    private Label lbRentalRevenua;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setTotalLabels("");
        setData_chart("total");
    }

    @FXML
    private void setRoot_SalesPerformance(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Would you like view Sales Performance page?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            try {
                App.setRoot("Dashboard");
                System.out.println("setRoot_SalesPerformance");
            } catch (IOException ex) {
                Logger.getLogger(MergeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            setData_chart("total");
        }

    }

    @FXML
    private void dashboard_btnSetChart_Service(ActionEvent event) {
        setData_chart("ser");
    }

    @FXML
    private void dashboard_btnSetChart_customer(ActionEvent event) {
        setData_chart("cus");

    }

    @FXML
    private void dashboard_btnSetChart_pitch(ActionEvent event) {
        setData_chart("pitch");
    }

    ChartDAO chartDAO = new ChartDAO();

    void setData_chart(String condition) {
        ObservableList<XYChart.Series> data3 = chartDAO.barChart_month_inside();
        XYChart.Series series1 = data3.get(0);
        XYChart.Series series2 = data3.get(1);
        XYChart.Series series3 = data3.get(2);
        switch (condition) {
            case "total":
                dashboard_barChart_Income.getData().setAll(series1, series3, series2);
                dashboard_barChart_Income.setTitle("Total Income Last  6 Months");
                break;
            case "pitch":
                dashboard_barChart_Income.getData().setAll(series2);
                dashboard_barChart_Income.setTitle("Pitch Income Last 6 Months");
                break;
            case "ser":
                dashboard_barChart_Income.getData().setAll(series3);
                dashboard_barChart_Income.setTitle("Service Income Last 6 Months");
                break;
            case "cus":
                dashboard_barChart_Income.getData().setAll(series1);
                dashboard_barChart_Income.setTitle("Customer Income Last 6 Months");
                break;
            default:
                break;
        }

    }

    void setTotalLabels(String condition) {
        HashMap<String, Double> tt = chartDAO.getTotalRevenue(condition);
        lbTotalRevenue.setText(tt.get("ttRevenue") + "M");
        lbRentalRevenua.setText(tt.get("ttRental") + "M");
        lbServiceRevenue.setText(tt.get("ttSer") + "K");
        int totalRentals = (int) Math.round(tt.get("numberOfRental"));
        lbTotalRentals.setText(String.valueOf(totalRentals));
    }
}
