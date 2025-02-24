package com.springbootacademy.batch7.pos.service;

import com.springbootacademy.batch7.pos.dto.paginated.PaginatedResponseOrderDetailsDTO;
import com.springbootacademy.batch7.pos.dto.request.OrderSaveRequestDTO;
import jakarta.validation.constraints.Max;

public interface OrderService {
    String addOrder(OrderSaveRequestDTO orderSaveRequestDTO);

    PaginatedResponseOrderDetailsDTO getAllOrderDetails(boolean status, int page, @Max(50) int size);
}
