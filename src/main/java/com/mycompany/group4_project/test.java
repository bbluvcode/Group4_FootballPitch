package com.mycompany.group4_project;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;

import DAO.PaymentBillDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class test {

    public static void main(String[] args) {
        PaymentBillDAO pmDAO = new PaymentBillDAO();
        HashMap<String, Integer> tt = pmDAO.getTotalRevenue();
        System.out.println("ttRevenue: "+tt.get("ttRevenue"));
        System.out.println(tt.get("ttRental"));
        System.out.println(tt.get("ttSer"));
    }
}
