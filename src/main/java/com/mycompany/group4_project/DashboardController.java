/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.group4_project;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import DAO.ChartDAO;
import DAO.PaymentBillDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
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
    private BarChart<String, Number> barChart_Top3Customer;
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
    private BarChart<Number, String> barChart_Top5Service;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setTotalLabels();
        setDataChart("");
        setValue_cboYear();
        setvalue_cboQuarter();
    }

    PaymentBillDAO pmDAO = new PaymentBillDAO();
    ChartDAO chartDAO = new ChartDAO();

    void setTotalLabels() {
        HashMap<String, Double> tt = pmDAO.getTotalRevenue();
        lbTotalRevenue.setText(tt.get("ttRevenue") + "M");
        lbRentalRevenua.setText(tt.get("ttRental") + "M");
        lbServiceRevenue.setText(tt.get("ttSer") + "K");
        int totalRentals = (int) Math.round(tt.get("numberOfRental"));
        lbTotalRentals.setText(String.valueOf(totalRentals));
    }

    void setValue_cboYear() {
        int currentYear = (int) (System.currentTimeMillis() / 1000 / 60 / 60 / 24 / 365);
        for (int i = 2024; i >= 2022; i--) {
            cboYear.getItems().add(i);
        }
    }

    void setvalue_cboQuarter() {
        cboQuarter.getItems().add("Quarter 1");
        cboQuarter.getItems().add("Quarter 2");
        cboQuarter.getItems().add("Quarter 3");
        cboQuarter.getItems().add("Quarter 4");
    }

    public String conditionFilter(String quarter) {
        String condition_quarter = "";

        if (quarter != null) {
            switch (quarter) {
                case "Quarter 1":
                    condition_quarter = "MONTH(payments.pay_date) BETWEEN 1 AND 3";
                    break;
                case "Quarter 2":
                    condition_quarter = "MONTH(payments.pay_date) BETWEEN 4 AND 6";
                    break;
                case "Quarter 3":
                    condition_quarter = "MONTH(payments.pay_date) BETWEEN 7 AND 9";
                    break;
                case "Quarter 4":
                    condition_quarter = "MONTH(payments.pay_date) BETWEEN 10 AND 12";
                    break;
                default:
                    break;
            }
        }

        String condition_year = null;
        if (cboYear.getValue() != null) {
            condition_year = "YEAR(payments.pay_date) = " + cboYear.getValue();
        }

        if (condition_year != null && !condition_quarter.isEmpty()) {
            return "WHERE " + condition_year + " AND " + condition_quarter;
        } else if (condition_year != null) {
            return "WHERE " + condition_year;
        } else if (!condition_quarter.isEmpty()) {
            return "WHERE " + condition_quarter;
        } else {
            return "";
        }
    }



    void setDataChart(String condition) {

        ObservableList<PieChart.Data> data = chartDAO.ServiceRevenues(condition);
        pieChart_ServiceCategory.setData(data);
        pieChart_ServiceCategory.setStartAngle(90);

        ObservableList<PieChart.Data> data2 = chartDAO.barChart_Top5PitchCategory(condition);
        pieChart_PitchCategory.setData(data2);
        pieChart_PitchCategory.setStartAngle(90);

        barChart_Top5Service.getData().setAll(chartDAO.barChart_Top5Service(condition));

        ObservableList<XYChart.Series> data3 = chartDAO.barChart_Top3Customer(condition);
        XYChart.Series series1 = data3.get(0);
        XYChart.Series series2 = data3.get(1);
        XYChart.Series series3 = data3.get(2);
        barChart_Top3Customer.getData().setAll(series1, series3, series2);

        ObservableList<XYChart.Series> data4 = chartDAO.lineChart(condition);
        XYChart.Series series11 = data4.get(0);
        XYChart.Series series22 = data4.get(1);
        XYChart.Series series33 = data4.get(2);
        lineChart_RevenueTrend.getData().setAll(series11, series33, series22);
    }

    @FXML
    private void BackHome(ActionEvent event) throws IOException {
        App.setRoot("AdminPage");
    }

    @FXML
    private void filterDashboard(ActionEvent event) {
        String condition = conditionFilter(cboQuarter.getValue());
        setDataChart(condition);
    }

    @FXML
    private void clearYear_btn(ActionEvent event) {
        cboYear.setValue(null);
        cboYear.setPromptText("All");
    }

    @FXML
    private void clearQuater_btn(ActionEvent event) {
        cboQuarter.setValue(null);
        cboQuarter.setPromptText("All");
    }
}
