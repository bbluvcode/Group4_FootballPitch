/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.group4_project;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.ChartDAO;
import javafx.collections.FXCollections;
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
    private ComboBox<String> dashboard_cboFilter;
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
        ini_dashboard();
    }

    void ini_dashboard() {
        setValue_cbo();
        setTotalLabels("");
        setData_chart("","total");
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
        } else {
            String filter = dashboard_cboFilter.getValue();
            setData_chart(filter,"total");
        }
    }

    @FXML
    private void dashboard_btnSetChart_Service(ActionEvent event) {
        String filter = dashboard_cboFilter.getValue();

        setData_chart(filter,"ser");
    }

    @FXML
    private void dashboard_btnSetChart_customer(ActionEvent event) {
        String filter = dashboard_cboFilter.getValue();

        setData_chart(filter,"cus");
    }

    @FXML
    private void dashboard_btnSetChart_pitch(ActionEvent event) {
        String filter = dashboard_cboFilter.getValue();
        setData_chart(filter,"pitch");
    }

    ChartDAO chartDAO = new ChartDAO();

    void setData_chart(String filter, String condition) {
        ObservableList<XYChart.Series> data, data3;
        if (filter.equals("Month")) {
            data3 = chartDAO.barChart_month_inside();
            data = chartDAO.barChart_monthCus_inside();
        } else {
            data3 = chartDAO.barChart_day_inside();
            data = chartDAO.barChart_dayCus_inside();
        }
        XYChart.Series series1 = data3.get(0);
        XYChart.Series series2 = data3.get(1);
        XYChart.Series series3 = data3.get(2);

        String titleSuffix = filter.equals("Day") ? " 7 Day" : " 6 Month";
        switch (condition) {
            case "total":
                dashboard_barChart_Income.getData().setAll(series1, series3, series2);
                dashboard_barChart_Income.setTitle("Total Income Last " + titleSuffix);
                break;
            case "pitch":
                dashboard_barChart_Income.getData().setAll(series2);
                dashboard_barChart_Income.setTitle("Pitch Income Last " + titleSuffix);
                break;
            case "ser":
                dashboard_barChart_Income.getData().setAll(series3);
                dashboard_barChart_Income.setTitle("Service Income Last " + titleSuffix);
                break;
            case "cus":
                XYChart.Series series11 = data.get(0);
                XYChart.Series series22 = data.get(1);
                XYChart.Series series33 = data.get(2);
                dashboard_barChart_Income.getData().setAll(series11, series33, series22);
                dashboard_barChart_Income.setTitle("Customer Income Last " + titleSuffix);
                break;
            default:
                dashboard_barChart_Income.getData().setAll(series1, series3, series2);
                dashboard_barChart_Income.setTitle("Total Income Last " + titleSuffix);
                break;
        }

    }

    void setTotalLabels(String filter) {
        HashMap<String, Double> tt;
        if (filter.equals("Day")) {
            tt = chartDAO.getTotalRevenue_day_inside();
        } else {
            tt = chartDAO.getTotalRevenue_inside();
        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        lbTotalRevenue.setText(formatter.format(tt.get("ttRevenue")));
        lbRentalRevenua.setText(formatter.format(tt.get("ttRental")));
        lbServiceRevenue.setText(formatter.format(tt.get("ttSer")));

        int totalRentals = (int) Math.round(tt.get("numberOfRental"));
        lbTotalRentals.setText(NumberFormat.getInstance().format(totalRentals));
    }

    void setValue_cbo() {
        dashboard_cboFilter.getItems().add("Day");
        dashboard_cboFilter.getItems().add("Month");
        dashboard_cboFilter.setValue("Month");
    }

    @FXML
    private void Filter(ActionEvent event) {
        String filter = dashboard_cboFilter.getValue();
        setTotalLabels(filter);
        setData_chart(filter, "total");
    }
}
