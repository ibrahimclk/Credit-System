package com.paycore.CreditSystem.service;

import com.paycore.CreditSystem.model.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomer(Integer id);

    void addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    boolean deleteCustomer(Integer id);

}

