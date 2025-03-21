package com.springbootacademy.batch7.pos.repo;

import com.springbootacademy.batch7.pos.dto.queryinterfaces.OrderDetailInterface;
import com.springbootacademy.batch7.pos.entity.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order, Integer> {

    @Query(value = "select c.customer_name as customerName, c.customer_address as customerAddress," +
                   " c.contact_number as contactNumber, o.order_date as orderDate, o.total as total"+
                   " from customer c, orders o where o.active_state = ?1 and c.customer_id = o.customer_id", nativeQuery = true)
    List<OrderDetailInterface> getAllOrderDetails(boolean status, PageRequest of);

    @Query(value = "select count(*) from customer c, orders o where o.active_state = 1 and c.customer_id = o.customer_id", nativeQuery = true)
    long countAllOrderDetails(boolean status);
}
