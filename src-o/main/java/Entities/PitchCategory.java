/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Admin
 */
public class PitchCategory {

    int idcp;
    String size;
    int price;

    public PitchCategory(int idcp, String size, int price) {
        this.idcp = idcp;
        this.size = size;
        this.price = price;
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
        return "PitchCategory{" + "idcp=" + idcp + ", size=" + size + ", price=" + price + '}';
    }   

}
