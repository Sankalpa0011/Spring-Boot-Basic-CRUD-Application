package com.springbootacademy.batch7.pos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsSaveRequestDTO {
    private int qty;
    private Double amount;
    private int orders;
    private int items;
}
