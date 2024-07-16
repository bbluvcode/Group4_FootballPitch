package com.mycompany.group4_project;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;

import DAO.ChartDAO;
import DAO.PaymentBillDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class test {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);
        LocalDate before6MonthDate = currentDate.minusMonths(6);
        System.out.println(before6MonthDate);
        int day = before6MonthDate.getDayOfMonth();
        before6MonthDate.atStartOfDay();
    }
}
