/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group4_project;

/**
 *
 * @author User
 */
public class Composite_Bill extends Composite_Service{
    int id;
    int qty;
    double total;

    public Composite_Bill(int id, int qty, double total, String name, int price, String type) {
        super(name, price, type);
        this.id = id;
        this.qty = qty;
        this.total = total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public int getId() {
        return id;
    }

    public int getQty() {
        return qty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
  
}
