/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author ADMIN
 */
public class Service_Rent extends ServiceCategory {

    int idsr;
    String name;
    int price;
    String img;
    int qoh;



    public Service_Rent(int idsr, String name, int price, String img, int qoh, int idc, String type) {
        super(idc, type);
        this.idsr = idsr;
        this.name = name;
        this.price = price;
        this.img = img;
        this.qoh = qoh;
    }
    
    

    public int getIdsr() {
        return idsr;
    }

    public void setIdsr(int idsr) {
        this.idsr = idsr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getQoh() {
        return qoh;
    }

    public void setQoh(int qoh) {
        this.qoh = qoh;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Service_Rent{" + "idsr=" + idsr + ", name=" + name + ", price=" + price + ", img=" + img + ", qoh=" + qoh + '}';
    }




    
}
