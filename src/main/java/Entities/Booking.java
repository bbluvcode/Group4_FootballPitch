/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author ADMIN
 */
public class Booking {

    int idb;
    String idu;
    int idp;
    String idk;
    Time time_book;
    int hrs;
    int deposit;
    int stt; // 1. pending, 2. completed, 3. cancel
    String khachhang_name, qluser_name, sanbong_name;
    Time time_start;

    public Booking() {
    }
    public Booking(int idb, String idu, int idp, String idk, Time time_book, int hrs, int deposit, int stt) {
        this.idb = idb;
        this.idu = idu;
        this.idp = idp;
        this.idk = idk;
        this.time_book = time_book;
        this.hrs = hrs;
        this.deposit = deposit;
        this.stt = stt;

    }

    public Booking(int idb, String idu, int idp, String idk, Time time_book, int hrs, int deposit, int stt, String khachhang_name, String qluser_name, String sanbong_name) {
        this.idb = idb;
        this.idu = idu;
        this.idp = idp;
        this.idk = idk;
        this.time_book = time_book;
        this.hrs = hrs;
        this.deposit = deposit;
        this.stt = stt;
        this.khachhang_name = khachhang_name;
        this.qluser_name = qluser_name;
        this.sanbong_name = sanbong_name;
    }
    public Booking(int idb, String idu, int idp, String idk, Time time_book, int hrs, int deposit, int stt, String khachhang_name, String qluser_name, String sanbong_name, Time time_start) {
        this.idb = idb;
        this.idu = idu;
        this.idp = idp;
        this.idk = idk;
        this.time_book = time_book;
        this.hrs = hrs;
        this.deposit = deposit;
        this.stt = stt;
        this.khachhang_name = khachhang_name;
        this.qluser_name = qluser_name;
        this.sanbong_name = sanbong_name;
        this.time_start = time_start;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public Time getTime_start() {
        return time_start;
    }

    public void setTime_start(Time time_start) {
        this.time_start = time_start;
    }

    @Override
    public String toString() {
        return "Booking{" + "idb=" + idb + ", idu=" + idu + ", idp=" + idp + ", idk=" + idk + ", time_book=" + time_book + ", hrs=" + hrs + ", deposit=" + deposit + ", stt=" + stt + ", khachhang_name=" + khachhang_name + ", qluser_name=" + qluser_name + ", sanbong_name=" + sanbong_name + '}';
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

    public int getDep() {
        return deposit;
    }

    public void setDep(int deposit) {
        this.deposit = deposit;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getSttDetail() {
        return stt == 1 ? "Pending" : stt == 2 ? "Completed" : "Cancel";
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



}
