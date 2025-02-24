package com.springbootacademy.batch7.pos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsResponseDTO {
    //customer
    private String customerName;
    private String customerAddress;
    private ArrayList<String> contactNumber;

    //order
    private Date orderDate;
    private Double total;
}
