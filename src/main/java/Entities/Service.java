/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 * @author ADMIN
 */
public class Service extends ServiceCategory {

    int ids;
    String name;
    int price;
    String img;
    int qty;
    int no;
    int total;
    int qoh;
    int idb;

    public Service() {
    }

    public Service(int ids, String name, int price, String img, int qty) {

        this.ids = ids;
        this.name = name;
        this.price = price;
        this.img = img;
        this.qty = qty;

    }

    public Service(int ids, String name, int price, String img, int qty, int idc, String type, int no) {
        super(idc, type);
        this.ids = ids;
        this.name = name;
        this.price = price;
        this.img = img;
        this.qty = qty;
        this.no = no;
    }

    public Service(int ids, String name, int price, String img, int qty, int idc, String type, int no, int idb) {
        super(idc, type);
        this.ids = ids;
        this.name = name;
        this.price = price;
        this.img = img;
        this.qty = qty;
        this.no = no;
        this.idb = idb;
    }

    public Service(int ids, String name, int price, String img, int qty, int idc, String type, int no, int total, int qoh) {
        super(idc, type);
        this.ids = ids;
        this.name = name;
        this.price = price;
        this.img = img;
        this.qty = qty;
        this.no = no;
        this.total = total;
        this.qoh = qoh;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getQoh() {
        return qoh;
    }

    public void setQoh(int qoh) {
        this.qoh = qoh;
    }


    public int getIdb() {
        return idb;
    }

    public void setIdb(int idb) {
        this.idb = idb;
    }

    @Override
    public String toString() {
        return "Service{" + "ids=" + ids + ", name=" + name + ", price=" + price + ", img=" + img + ", qty=" + qty + ", idc=" + idc + ", type=" + type + ", no=" + no + ", total=" + total + ", qoh=" + qoh + '}';
    }

}
