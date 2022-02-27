package com.paycore.CreditSystem.service.impl;

import com.paycore.CreditSystem.model.entity.Application;
import com.paycore.CreditSystem.model.entity.Customer;
import com.paycore.CreditSystem.repository.CustomerRepository;
import com.paycore.CreditSystem.service.ApplicationService;
import com.paycore.CreditSystem.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ApplicationService applicationService;

    @InjectMocks
    private CustomerServiceImpl customerService;


    @Test
    void getAllCustomers() {
        Customer customer1 = new Customer(1,"1111111111","Test","TestLastname",10000,"905555555555", null);
        Customer customer2 = new Customer(1,"2222222222","Test2","TestLastname2",20000,"905555555552", null);
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> allCustomers = customerService.getAllCustomers();
        Assertions.assertEquals(customers.size(), allCustomers.size());
    }

    @Test
    void getCustomer() {
        Customer customer1 = new Customer(1,"1111111111","Test","TestLastname",10000,"905555555555", null);

        Optional<Customer> customer1opt = Optional.of(customer1);
        when(customerRepository.findById(1)).thenReturn(customer1opt);

        Customer actualCustomer = customerService.getCustomer(1);



        assertEquals(customer1, actualCustomer);
    }

    @Test
    void addCustomer() {

        Customer customer1 = new Customer(1,"1111111111","Test","TestLastname",10000,"905555555555", null);
        when(customerRepository.save(customer1)).thenReturn(customer1);

        customerService.addCustomer(customer1);

        verify(customerRepository, times(1)).save(customer1);

    }
}