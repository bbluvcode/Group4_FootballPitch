/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group4_project;

/**
 *
 * @author User
 */
public class CompositeBill {

    int id, price, qty, total;
    String name, type;

    public CompositeBill(int id, int price, int qty, int total, String name, String type) {
        this.id = id;
        this.price = price;
        this.qty = qty;
        this.total = total;
        this.name = name;
        this.type = type;
    }

}
