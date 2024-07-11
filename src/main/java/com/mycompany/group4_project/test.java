package com.mycompany.group4_project;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class test {

    public static void main(String[] args) {

        Time timefromdb = Time.valueOf("12:00:00");


        LocalTime timestart = timefromdb.toLocalTime();
        LocalTime timeNow = LocalTime.now();
        Duration duration = Duration.between(timestart, timeNow);
long hrs = duration.toHours();
long minutes = duration.toMinutes() % 60;
        System.out.println(hrs+":"+ minutes);
    }
}
