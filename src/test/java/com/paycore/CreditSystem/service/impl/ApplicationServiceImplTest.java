package com.paycore.CreditSystem.service.impl;

import com.paycore.CreditSystem.model.entity.Application;
import com.paycore.CreditSystem.model.entity.Customer;
import com.paycore.CreditSystem.repository.ApplicationRepository;
import com.paycore.CreditSystem.repository.CustomerRepository;
import com.paycore.CreditSystem.service.ApplicationService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
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
class ApplicationServiceImplTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @Mock
    private SmsService smsService;

    @Mock
    private ScoreService scoreService;

    @InjectMocks
    private ApplicationServiceImpl applicationService;

    @Test
    void getAllApplications() {

        Customer customer1 = new Customer(1,"1111111111","Test","TestLastname",10000,"905555555555", null);
        Customer customer2 = new Customer(1,"2222222222","Test2","TestLastname2",20000,"905555555552", null);
        Application application1 = Application.builder().id(1).credit_limit(20000).credit_result("CONFIRMED").customer(customer1).build();
        Application application2 = Application.builder().id(2).credit_limit(10000).credit_result("CONFIRMED").customer(customer2).build();
        List<Application> applications = new ArrayList<>();
        applications.add(application1);
        applications.add(application2);

        when(applicationRepository.findAll()).thenReturn(applications);

        List<Application> allapplications = applicationService.getAllApplications();

        assertEquals(applications.size(), allapplications.size());
    }

    @Test
    void getStatus() {
        Customer customer1 = new Customer(1,"2222222222","Test2","TestLastname2",20000,"905555555552", null);
        Application application1 = Application.builder().id(1).credit_limit(20000).credit_result("CONFIRMED").customer(customer1).build();

        when(applicationRepository.findByCustomerIdentityno(customer1.getIdentityno())).thenReturn(application1);

        Application actual = applicationService.getStatus("2222222222");

        assertEquals(application1, actual);


    }

    @Test
    void makeApplication() {
        Customer customer1 = new Customer(0,"2222222222","Test2","TestLastname2",20000,"905555555552", null);
        Application application1 = Application.builder().id(0).credit_limit(80000).credit_result("CONFIRMED").customer(customer1).build();

        when(scoreService.getScore(customer1.getIdentityno())).thenReturn(1200);
        when(applicationRepository.save(application1)).thenReturn(application1);
        when(smsService.sms(customer1.getPhone(), Boolean.TRUE)).thenReturn(Boolean.TRUE);

        Application actual = applicationService.makeApplication(customer1);
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(actual.getCredit_result(), application1.getCredit_result()),
                () -> assertEquals(actual.getCredit_limit(), application1.getCredit_limit()),
                () -> assertEquals(actual.getCustomer(), application1.getCustomer())
        );

    }
}