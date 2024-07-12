/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group4_project;

/**
 *
 * @author User
 */
public class Pitch extends PitchCategory {

    public int idp;
    public String name;
    public int available;
    public int no;

    public Pitch() {
        super(0, null, 0);
    }

    public Pitch(int idp, String name, int available, int idcp, String size, int price, int no) {
        super(idcp, size, price);
        this.idp = idp;
        this.name = name;
        this.available = available;
        this.no = no;
    }

    public Pitch(int idp, String name, int available, int idcp, String size, int price) {
        super(idcp, size, price);
        this.idp = idp;
        this.name = name;
        this.available = available;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Pitch{" + "idp=" + idp + ", name=" + name + ", available=" + available + ", idcp=" + idcp + ", size=" + size + ", price=" + price + '}';
    }

    public String getAvailableDescription() {
        return available == 1 ? "Available" : available == 2 ? "Renting" : available == 3 ? "Booking" : "Error";
    }

}
