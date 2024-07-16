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
        LocalDate before1week = currentDate.minusWeeks(1);
        System.out.println(before1week);
    }
}
