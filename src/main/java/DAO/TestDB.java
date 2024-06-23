/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.PaymentBill;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


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

/*        LocalTime crHrs = LocalTime.now().plusMinutes(15);
        int crHours = crHrs.getHour();
        int crMinutes = crHrs.getMinute();
        System.out.println(crHours +" va " + crMinutes);*/

        String start_time = "10:20:30";
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime startTime = LocalTime.parse(start_time, timeFormatter);

        LocalTime end_time = LocalTime.parse("11:10:20", timeFormatter);

        Duration duration = Duration.between(startTime, end_time);

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        LocalTime time = LocalTime.of((int) hours, (int) minutes);

        System.out.println(hours + " hours, " + minutes + " minutes, ");
   /*     System.out.println(startTime);
        System.out.println(end_time);
        System.out.println(time);*/
        int timedura = time.getHour();
        System.out.println(timedura);
    }
}
