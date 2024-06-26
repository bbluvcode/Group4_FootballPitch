/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.sql.Date;
import java.sql.Time;

/**
 * @author ADMIN
 */
public class PaymentBill {

    int idb;
    String idu;
    int idp;
    String idk;
    Time time_start;
    Time time_end;
    int hrs_used;
    Date pay_date;
    int deposit;
    int tt_booking;
    int tt_service;
    int tt_payment;
    boolean comp;
    Time time_book;
    int hrs;
    int stt;
    String khachhang_name;
    String qluser_name;
    String sanbong_name;
    int price_pitch;

    public PaymentBill() {
    }

    public PaymentBill(int idb, String idu, int idp, String idk, Time time_start, Time time_end, int hrs_used, Date pay_date, int deposit, int tt_booking, int tt_service, int tt_payment, boolean comp, String khachhang_name, String qluser_name, String sanbong_name, int price_pitch) {
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
        this.khachhang_name = khachhang_name;
        this.qluser_name = qluser_name;
        this.sanbong_name = sanbong_name;
        this.price_pitch = price_pitch;
    }


    public PaymentBill(int idb, String idu, int idp, String idk, Time time_start, Time time_end, int hrs_used, Date pay_date, int deposit, int tt_booking, int tt_service, int tt_payment, boolean comp, Time time_book, int hrs, int stt, String khachhang_name, String qluser_name, String sanbong_name, int price_pitch) {
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
        this.time_book = time_book;
        this.hrs = hrs;
        this.stt = stt;
        this.khachhang_name = khachhang_name;
        this.qluser_name = qluser_name;
        this.sanbong_name = sanbong_name;
        this.price_pitch = price_pitch;

    }

    public PaymentBill(int idb, int idp, String idk, Time time_start, Time time_end, int hrs_used, Date pay_date, int deposit, int tt_booking, int tt_service, int tt_payment, Time time_book) {
        this.idb = idb;
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
        this.time_book = time_book;

    }

    public PaymentBill(int idb, int hrs_used, int tt_payment, int tt_booking, int tt_service) {
        this.idb = idb;
        this.hrs_used = hrs_used;
        this.tt_payment = tt_payment;
        this.tt_booking = tt_booking;
        this.tt_service = tt_service;
    }

    @Override
    public String toString() {
        return "PaymentBill{" +
                "idb=" + idb +
                ", idu='" + idu + '\'' +
                ", idp=" + idp +
                ", idk='" + idk + '\'' +
                ", time_start=" + time_start +
                ", time_end=" + time_end +
                ", hrs_used=" + hrs_used +
                ", pay_date=" + pay_date +
                ", deposit=" + deposit +
                ", tt_booking=" + tt_booking +
                ", tt_service=" + tt_service +
                ", tt_payment=" + tt_payment +
                ", comp=" + comp +
                ", time_book=" + time_book +
                ", hrs=" + hrs +
                ", stt=" + stt +
                ", khachhang_name='" + khachhang_name + '\'' +
                ", qluser_name='" + qluser_name + '\'' +
                ", sanbong_name='" + sanbong_name + '\'' +
                ", price_pitch=" + price_pitch +
                '}';
    }

    public int getIdb() {
        return idb;
    }

    public void setIdb(int idb) {
        this.idb = idb;
    }

    public String getIdu() {
        return idu;
    }

    public void setIdu(String idu) {
        this.idu = idu;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getIdk() {
        return idk;
    }

    public void setIdk(String idk) {
        this.idk = idk;
    }

    public Time getTime_start() {
        return time_start;
    }

    public void setTime_start(Time time_start) {
        this.time_start = time_start;
    }

    public Time getTime_end() {
        return time_end;
    }

    public void setTime_end(Time time_end) {
        this.time_end = time_end;
    }

    public int getHrs_used() {
        return hrs_used;
    }

    public void setHrs_used(int hrs_used) {
        this.hrs_used = hrs_used;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTt_booking() {
        return tt_booking;
    }

    public void setTt_booking(int tt_booking) {
        this.tt_booking = tt_booking;
    }

    public int getTt_service() {
        return tt_service;
    }

    public void setTt_service(int tt_service) {
        this.tt_service = tt_service;
    }

    public int getTt_payment() {
        return tt_payment;
    }

    public void setTt_payment(int tt_payment) {
        this.tt_payment = tt_payment;
    }

    public boolean isComp() {
        return comp;
    }

    public void setComp(boolean comp) {
        this.comp = comp;
    }

    public Time getTime_book() {
        return time_book;
    }

    public void setTime_book(Time time_book) {
        this.time_book = time_book;
    }

    public int getHrs() {
        return hrs;
    }

    public void setHrs(int hrs) {
        this.hrs = hrs;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getKhachhang_name() {
        return khachhang_name;
    }

    public void setKhachhang_name(String khachhang_name) {
        this.khachhang_name = khachhang_name;
    }

    public String getQluser_name() {
        return qluser_name;
    }

    public void setQluser_name(String qluser_name) {
        this.qluser_name = qluser_name;
    }

    public String getSanbong_name() {
        return sanbong_name;
    }

    public void setSanbong_name(String sanbong_name) {
        this.sanbong_name = sanbong_name;
    }

    public int getPrice_pitch() {
        return price_pitch;
    }

    public void setPrice_pitch(int price_pitch) {
        this.price_pitch = price_pitch;
    }
}
