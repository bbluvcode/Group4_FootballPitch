/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group4_project;

import java.sql.Date;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import java.text.SimpleDateFormat;
/**
 *
 * @author User
 */
public class DateCellFactory implements Callback<TableColumn<PaymentBill, Date>, TableCell<PaymentBill, Date>> {
    private final SimpleDateFormat formatter;

    public DateCellFactory(String pattern) {
        this.formatter = new SimpleDateFormat(pattern);
    }

    @Override
    public TableCell<PaymentBill, Date> call(TableColumn<PaymentBill, Date> param) {
        return new TableCell<PaymentBill, Date>() {
            @Override
            protected void updateItem(Date item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(formatter.format(item));
                }
            }
        };
    }
}