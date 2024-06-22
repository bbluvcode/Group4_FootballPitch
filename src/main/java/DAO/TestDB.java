/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.Service;
import Entities.Service;
import Entities.Service;
import javafx.collections.ObservableList;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;


/**
 * @author ADMIN
 */
public class TestDB {

    public static void main(String[] args) {
//        Time t = Time.valueOf(LocalTime.now());
//        Time t2 = Time.valueOf("10:20:20");
//        System.out.println(t.toString());
//        System.out.println(t);
//        System.out.println(t2.toString());

//        PitchDAO pitchDAO = new PitchDAO();

        LocalTime crHrs = LocalTime.now().plusMinutes(15);
        int crHours = crHrs.getHour();
        int crMinutes = crHrs.getMinute();
        System.out.println(crHours +" va " + crMinutes);
    }
}
