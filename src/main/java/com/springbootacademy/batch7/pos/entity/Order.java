package com.springbootacademy.batch7.pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    @Id
    @Column(name = "order_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date orderDate;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeStatus;

    @OneToMany(mappedBy="orders")
    private Set<OrderDetails> orderDetails;

    public Order(Customer customer, Date orderDate, Double total, boolean activeStatus) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.total = total;
        this.activeStatus = activeStatus;
    }
}
