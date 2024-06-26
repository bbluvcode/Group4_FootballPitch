/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.Service;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


/**
 * @author ADMIN
 */
public class TestDB {

    public static void main(String[] args) {
        ServiceDAO pb = new ServiceDAO();
//        pb.getAll();
        for (Service p : pb.getAll()) {
            System.out.println(p.toString());
        }
    }
}
