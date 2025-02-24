package com.springbootacademy.batch7.pos.service.impl;

import com.springbootacademy.batch7.pos.dto.request.OrderSaveRequestDTO;
import com.springbootacademy.batch7.pos.entity.Order;
import com.springbootacademy.batch7.pos.entity.OrderDetails;
import com.springbootacademy.batch7.pos.repo.CustomerRepo;
import com.springbootacademy.batch7.pos.repo.ItemRepo;
import com.springbootacademy.batch7.pos.repo.OrderDetailsRepo;
import com.springbootacademy.batch7.pos.repo.OrderRepo;
import com.springbootacademy.batch7.pos.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private ItemRepo itemRepo;

    @Override
    @Transactional
    public String addOrder(OrderSaveRequestDTO orderSaveRequestDTO) {
        Order order = new Order(
                customerRepo.getReferenceById(orderSaveRequestDTO.getCustomer()),
                orderSaveRequestDTO.getOrderDate(),
                orderSaveRequestDTO.getTotal()
        );
        orderRepo.save(order);

        if (orderRepo.existsById(order.getOrderId())) {
            List<OrderDetails> ordersDetails = modelMapper.
                    map(orderSaveRequestDTO.getOrderDetails(),  new TypeToken<List<OrderDetails>>() {}.getType());
            for (int i = 0; i < ordersDetails.size(); i++) {
                ordersDetails.get(i).setOrders(order);
                ordersDetails.get(i).setItems(itemRepo.getReferenceById(orderSaveRequestDTO.getOrderDetails().get(i).getItems()));
            }
            if (ordersDetails.size() > 0) {
                orderDetailsRepo.saveAll(ordersDetails);
            }
            return "Saved";
        }
        return "Failed";
    }
}
