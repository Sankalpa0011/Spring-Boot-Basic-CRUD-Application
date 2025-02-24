package com.springbootacademy.batch7.pos.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "customer_salary")
    private double customerSalary;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "contact_number", columnDefinition = "json")
    private ArrayList<String> contactNumber;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy="customer")
    private Set<Order> order;


    // no arg constructor
    public Customer() {

    }

    // full arg constructor
    public Customer(int customerId, String customerName, String customerAddress, double customerSalary, ArrayList<String> contactNumber, String nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.active = active;
    }

    // getters
    public int getCustomerId() {
        return customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public double getCustomerSalary() {
        return customerSalary;
    }
    public ArrayList<String> getContactNumber() {
        return contactNumber;
    }
    public String getNic() {
        return nic;
    }
    public boolean isActive() {
        return active;
    }

    // setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }
    public void setContactNumber(ArrayList<String> contactNumber) {
        this.contactNumber = contactNumber;
    }
    public void setNic(String nic) {
        this.nic = nic;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    // toString method
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                ", contactNumber=" + contactNumber +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }

}

