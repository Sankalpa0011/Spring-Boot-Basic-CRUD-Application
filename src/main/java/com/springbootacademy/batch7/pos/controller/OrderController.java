package com.springbootacademy.batch7.pos.controller;

import com.springbootacademy.batch7.pos.dto.request.OrderSaveRequestDTO;
import com.springbootacademy.batch7.pos.service.OrderService;
import com.springbootacademy.batch7.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@CrossOrigin
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody OrderSaveRequestDTO orderSaveRequestDTO) {
        String id = orderService.addOrder(orderSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", id),
                HttpStatus.CREATED
        );
    }
}
