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
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        Customer customer2 = new Customer(2,"2222222222","Test2","TestLastname2",20000,"905555555552", null);

        CustomerDTO customerDTO1 = new CustomerDTO("1111111111","Test","TestLastname",10000,"905555555555");
        CustomerDTO customerDTO2 = new CustomerDTO("2222222222","Test2","TestLastname2",20000,"905555555552");

        Application application1 = new Application(1,20000,"CONFIRMED",customer1);
        Application application2 = new Application(2,10000,"CONFIRMED",customer2);

        ApplicationDTO applicationDTO1 = new ApplicationDTO(20000,"CONFIRMED",customerDTO1);
        ApplicationDTO applicationDTO2 = new ApplicationDTO(10000,"CONFIRMED",customerDTO2);

       // Application application1 = Application.builder().id(1).credit_limit(20000).credit_result("CONFIRMED").customer(customer1).build();
       // Application application2 = Application.builder().id(2).credit_limit(10000).credit_result("CONFIRMED").customer(customer2).build();

        List<Application> applications = new ArrayList<>();

        applications.add(application1);
        applications.add(application2);

        List<ApplicationDTO> applicationDTOS = Arrays.asList(applicationDTO1,applicationDTO2);
        //applicationDTOS.add(applicationDTO1);
        //applicationDTOS.add(applicationDTO2);


        when(applicationService.getAllApplications()).thenReturn(applications);
        when(applicationMapper.toDtos(applications)).thenReturn(applicationDTOS);

        List<ApplicationDTO> actual = applicationController.getAllApplications();
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(actual, applicationDTOS),
                () -> assertEquals(actual.size(), applicationDTOS.size())
        );
    }

    @Test
    void getStatus() {
        Customer customer1 = new Customer(1,"1111111111","Test","TestLastname",10000,"905555555555", null);

        CustomerDTO customerDTO1 = new CustomerDTO("1111111111","Test","TestLastname",10000,"905555555555");

        Application application1 = new Application(1,20000,"CONFIRMED",customer1);

        ApplicationDTO applicationDTO1 = new ApplicationDTO(20000,"CONFIRMED",customerDTO1);

        when(applicationService.getStatus(customer1.getIdentityno())).thenReturn(application1);
        when(applicationMapper.toDto(application1)).thenReturn(applicationDTO1);

        ApplicationDTO actual = applicationController.getStatus("1111111111");

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(actual.getCustomer(), applicationDTO1.getCustomer()),
                () -> assertEquals(actual, applicationDTO1)
        );

    }
}