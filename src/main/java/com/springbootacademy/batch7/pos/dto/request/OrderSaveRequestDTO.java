package com.springbootacademy.batch7.pos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderSaveRequestDTO {
    private int customer;
    private Date orderDate;
    private Double total;
    private boolean activeStatus;
    private List<OrderDetailsSaveRequestDTO> orderDetails;
}
