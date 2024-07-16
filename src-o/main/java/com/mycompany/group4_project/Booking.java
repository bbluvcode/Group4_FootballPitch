/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group4_project;

import java.sql.Time;

/**
 *
 * @author User
 */
public class Booking {
    int idb;
    String idu;
    int idp;
    String idk;
    Time time;
    int hrs;
    int dep;
    int stt; // 1. pending, 2. completed, 3. cancel
    String khachhang_name, qluser_name, sanbong_name;

    public Booking() {
    }

    public Booking(int idb, String idu, int idp, String idk, Time time, int hrs, int dep, int stt, String khachhang_name, String qluser_name, String sanbong_name) {
        this.idb = idb;
        this.idu = idu;
        this.idp = idp;
        this.idk = idk;
        this.time = time;
        this.hrs = hrs;
        this.dep = dep;
        this.stt = stt;
        this.khachhang_name = khachhang_name;
        this.qluser_name = qluser_name;
        this.sanbong_name = sanbong_name;
    }

    public Booking(Time time, int hrs, int stt, String khachhang_name, String qluser_name, String sanbong_name) {
        this.time = time;
        this.hrs = hrs;
        this.stt = stt;
        this.khachhang_name = khachhang_name;
        this.qluser_name = qluser_name;
        this.sanbong_name = sanbong_name;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getHrs() {
        return hrs;
    }

    public void setHrs(int hrs) {
        this.hrs = hrs;
    }

    public int getDep() {
        return dep;
    }

    public void setDep(int dep) {
        this.dep = dep;
    }
    
    public String getSttDetail(){
        return stt == 1 ? "Pending" : stt == 2 ? "Completed" : "Cancel";
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
}
