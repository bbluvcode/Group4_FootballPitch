/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group4_project;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
/**
 *
 * @author User
 */
public class PaymentBill extends Booking {
    int idb;
    String idu;
    int idp;
    String idk;
    Time time_start;
    Time time_end;
    int hrs_used ;
    Date pay_date;
    int deposit;
    int tt_booking;
    int tt_service;
    int tt_payment;
    boolean comp;

    public PaymentBill() {
    }
    
    public PaymentBill(int idb, String idu, int idp, String idk, Time time_start, Time time_end, int hrs_used, Date pay_date, int deposit, int tt_booking, int tt_service, int tt_payment, boolean comp) {
        this.idb = idb;
        this.idu = idu;
        this.idp = idp;
        this.idk = idk;
        this.time_start = time_start;
        this.time_end = time_end;
        this.hrs_used = hrs_used;
        this.pay_date = pay_date;
        this.deposit = deposit;
        this.tt_booking = tt_booking;
        this.tt_service = tt_service;
        this.tt_payment = tt_payment;
        this.comp = comp;
    }

    public PaymentBill(int idb, Time time_start, Time time_end, int hrs_used, Date pay_date, int deposit, int tt_booking, int tt_service, int tt_payment, boolean comp, Time time, int hrs, int stt, String khachhang_name, String qluser_name, String sanbong_name) {
        super(time, hrs, stt, khachhang_name, qluser_name, sanbong_name);
        this.idb = idb;
        this.time_start = time_start;
        this.time_end = time_end;
        this.hrs_used = hrs_used;
        this.pay_date = pay_date;
        this.deposit = deposit;
        this.tt_booking = tt_booking;
        this.tt_service = tt_service;
        this.tt_payment = tt_payment;
        this.comp = comp;
    }
    public PaymentBill(int idb, Time time_start, Time time_end, Date pay_date, int deposit, int tt_booking, int tt_service, int tt_payment, boolean comp, Time time, int hrs, int stt, String khachhang_name, String qluser_name, String sanbong_name) {
        super(time, hrs, stt, khachhang_name, qluser_name, sanbong_name);
        this.idb = idb;
        this.time_start = time_start;
        this.time_end = time_end;
        this.hrs_used = calHoursUsed();
        this.pay_date = pay_date;
        this.deposit = deposit;
        this.tt_booking = tt_booking;
        this.tt_service = tt_service;
        this.tt_payment = tt_payment;
        this.comp = comp;
    }
    @Override
    public int getIdb() {
        return idb;
    }

    @Override
    public String getIdu() {
        return idu;
    }

    @Override
    public int getIdp() {
        return idp;
    }

    @Override
    public String getIdk() {
        return idk;
    }

    public Time getTime_start() {
        return time_start;
    }

    public Time getTime_end() {
        return time_end;
    }

    public int getHrs_used() {
        return hrs_used;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getTt_booking() {
        return tt_booking;
    }

    public int getTt_service() {
        return tt_service;
    }

    public int getTt_payment() {
        return tt_payment;
    }

    public boolean isComp() {
        return comp;
    }
    
    public String getCompleted() {
        return comp ? "Yes" : "No";
    }
    private int calHoursUsed() {
        Duration duration = Duration.between(time_end.toLocalTime(), time_start.toLocalTime());
        return (int) duration.toHours();
    }

    public void setTime_start(Time time_start) {
        this.time_start = time_start;
    }

    public void setTime_end(Time time_end) {
        this.time_end = time_end;
    }

    public void setHrs_used(int hrs_used) {
        this.hrs_used = hrs_used;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public void setTt_booking(int tt_booking) {
        this.tt_booking = tt_booking;
    }

    public void setTt_service(int tt_service) {
        this.tt_service = tt_service;
    }

    public void setTt_payment(int tt_payment) {
        this.tt_payment = tt_payment;
    }

    public void setComp(boolean comp) {
        this.comp = comp;
    }
    
}