package com.paycore.CreditSystem.controller;

import com.paycore.CreditSystem.model.DTO.CustomerDTO;
import com.paycore.CreditSystem.model.entity.Customer;
import com.paycore.CreditSystem.model.mapper.CustomerMapper;
import com.paycore.CreditSystem.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {
    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    @Mock
    CustomerMapper customerMapper;

    @Test
    void getAllCustomers() {

        Customer customer1 = new Customer(1,"1111111111","Test","TestLastname",10000,"905555555555", null);
        Customer customer2 = new Customer(1,"2222222222","Test2","TestLastname2",20000,"905555555552", null);

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);


        when(customerService.getAllCustomers()).thenReturn(customers);

        List<CustomerDTO> actual = customerController.getAllCustomers();
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(actual.size(), customers.size())
        );

    }
}