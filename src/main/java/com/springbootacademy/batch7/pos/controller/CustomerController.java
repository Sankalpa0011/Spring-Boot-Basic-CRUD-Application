package com.springbootacademy.batch7.pos.controller;

import com.springbootacademy.batch7.pos.dto.CustomerDTO;
import com.springbootacademy.batch7.pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch7.pos.service.impl.CustomerServiceIMPL;
import com.springbootacademy.batch7.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceIMPL customerService;

    // Create
    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
//        CustomerServiceIMPL customerServiceIMPL = new CustomerServiceIMPL();
//        customerServiceIMPL.saveCustomer(customerDTO);
        String message = customerService.saveCustomer(customerDTO);
        return message;
    }

    // Update
    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String message = customerService.updateCustomer(customerUpdateDTO);
        return message;
    }

    // Get by id
    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

    // Get all
//    @GetMapping(
//            path = "/get-all-customers"
//    )
//    public List<CustomerDTO> getAllCustomers() {
//        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
//        return allCustomers;
//    }

    @GetMapping(
            path = "/get-all-customers"
    )
    public ResponseEntity<StandardResponse> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", allCustomers),
                HttpStatus.OK
        );
    }

    // Delete
    @DeleteMapping(
            path = "delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }

    // Get all by active state
    @GetMapping(
            path = "/get-all-customers-by-active-state/{status}"
    )
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable(value = "status") boolean activeStatus) {
        List<CustomerDTO> allCustomersByActiveState = customerService.getAllCustomersByActiveState(activeStatus);
        return allCustomersByActiveState;
    }
}
