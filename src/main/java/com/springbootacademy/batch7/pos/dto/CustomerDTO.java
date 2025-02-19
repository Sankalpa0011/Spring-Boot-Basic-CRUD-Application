package com.springbootacademy.batch7.pos.dto;

import java.util.ArrayList;

public class CustomerDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private ArrayList<String> contactNumber;
    private String nic;
    private boolean active;

    // no args constructor
    public CustomerDTO() {}

    // all args constructor
    public CustomerDTO(int customerId, String customerName, String customerAddress, double customerSalary, ArrayList<String> contactNumber, String nic, boolean active) {
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
