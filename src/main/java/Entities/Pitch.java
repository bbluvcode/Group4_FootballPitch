/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Admin
 */
public class Pitch extends PitchCategory {

    int idp;
    String name;
    int available; //1. available, 2. not available, 3. booked

    public Pitch(int idp, String name, int available, int idcp, String size, int price) {
        super(idcp, size, price);
        this.idp = idp;
        this.name = name;
        this.available = available;
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

    public int getIdcp() {
        return idcp;
    }

    public void setIdcp(int idcp) {
        this.idcp = idcp;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pitch{" + "idp=" + idp + ", name=" + name + ", available=" + available + "idcp=" + idcp + ", size=" + size + ", price=" + price + '}';
    }

    public String getAvailableDescription() {
        return available == 1 ? "Trống" : available == 2 ? "Có khách" : available == 3 ? "Đã đặt" : "Lỗi";
    }

}
