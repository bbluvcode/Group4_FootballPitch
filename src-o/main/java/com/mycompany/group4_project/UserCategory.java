/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group4_project;

/**
 *
 * @author User
 */
public class UserCategory {
    int idt;
    String type;

    public UserCategory() {
    }

    public UserCategory(int idt, String type) {
        this.idt = idt;
        this.type = type;
    }

    public int getIdt() {
        return idt;
    }

    public void setIdt(int idt) {
        this.idt = idt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserType{" + "idt=" + idt + ", type=" + type + '}';
    }   
}
