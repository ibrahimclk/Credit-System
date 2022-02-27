package com.paycore.CreditSystem.controller;

import com.paycore.CreditSystem.model.DTO.ApplicationDTO;
import com.paycore.CreditSystem.model.DTO.CustomerDTO;
import com.paycore.CreditSystem.model.entity.Application;
import com.paycore.CreditSystem.model.entity.Customer;
import com.paycore.CreditSystem.model.mapper.ApplicationMapper;
import com.paycore.CreditSystem.model.mapper.CustomerMapper;
import com.paycore.CreditSystem.service.ApplicationService;
import com.paycore.CreditSystem.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationControllerTest {
    @Mock
    ApplicationService applicationService;

    @InjectMocks
    ApplicationController applicationController ;

    @Mock
    ApplicationMapper applicationMapper;

    @Test
    void getAllApplications() {
        Customer customer1 = new Customer(1,"1111111111","Test","TestLastname",10000,"905555555555", null);
        Customer customer2 = new Customer(1,"2222222222","Test2","TestLastname2",20000,"905555555552", null);

        Application application1 = Application.builder().id(1).credit_limit(20000).credit_result("CONFIRMED").customer(customer1).build();
        Application application2 = Application.builder().id(2).credit_limit(10000).credit_result("CONFIRMED").customer(customer2).build();

        List<Application> applications = new ArrayList<>();

        applications.add(application1);
        applications.add(application2);


        when(applicationService.getAllApplications()).thenReturn(applications);

        List<ApplicationDTO> actual = applicationController.getAllApplications();
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(actual.size(), applications.size())
        );
    }

    @Test
    void getStatus() {
    }
}