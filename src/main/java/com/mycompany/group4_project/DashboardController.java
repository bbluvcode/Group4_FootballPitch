/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.group4_project;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import DAO.PaymentBillDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.application.Platform;


/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane Dashboard_page;
    @FXML
    private BarChart<?, ?> barChart_Top3Customer;
    @FXML
    private PieChart pieChart_ServiceCategory;
    @FXML
    private Label lbTotalRevenue;
    @FXML
    private Label lbTotalRentals;
    @FXML
    private Label lbRentalRevenua;
    @FXML
    private Label lbServiceRevenue;
    @FXML
    private ComboBox<Integer> cboYear;
    @FXML
    private ComboBox<String> cboQuarter;
    @FXML
    private LineChart<?, ?> lineChart_RevenueTrend;
    @FXML
    private PieChart pieChart_PitchCategory;
    @FXML
    private BarChart<?, ?> barChart_Top5Service;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setTotalLabels();
    }

    PaymentBillDAO pmDAO = new PaymentBillDAO();

    void setTotalLabels() {
        HashMap<String, Integer> tt = pmDAO.getTotalRevenue();
        lbTotalRevenue.setText(String.valueOf(tt.get("ttRevenue")));
        lbRentalRevenua.setText(String.valueOf(tt.get("ttRental")));
        lbServiceRevenue.setText(String.valueOf(tt.get("ttSer")));
        lbTotalRentals.setText(String.valueOf(tt.get("numberOfRental")));
    }

    @FXML
    private void BackHome(ActionEvent event) throws IOException {
        App.setRoot("StaffPage");
    }
}
