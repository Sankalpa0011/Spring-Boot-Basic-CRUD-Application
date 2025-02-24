package com.springbootacademy.batch7.pos.dto.queryinterfaces;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailInterface {

    // type methods
    String getCustomerName();             //    private String customerName;

    String getCustomerAddress();          //    private String customerAddress;

    ArrayList getContactNumber();         //    private ArrayList<String> contactNumber;

    Date getOrderDate();                  //    private Date orderDate;

    Double getTotal();                    //    private Double total;
}
