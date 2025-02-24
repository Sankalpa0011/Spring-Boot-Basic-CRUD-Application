package com.springbootacademy.batch7.pos.service;

import com.springbootacademy.batch7.pos.dto.request.OrderSaveRequestDTO;

public interface OrderService {
    String addOrder(OrderSaveRequestDTO orderSaveRequestDTO);
}
