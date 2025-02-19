package com.springbootacademy.batch7.pos.repo;

import com.springbootacademy.batch7.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    String getCustomerByCustomerId(int customerId);
}
