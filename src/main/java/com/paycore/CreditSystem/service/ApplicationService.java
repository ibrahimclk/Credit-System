package com.paycore.CreditSystem.service;

import com.paycore.CreditSystem.model.entity.Application;
import com.paycore.CreditSystem.model.entity.Customer;

import java.util.List;

public interface ApplicationService {
    List<Application> getAllApplications();

    Application getStatus(String identityno);

    Application makeApplication(Customer customer);



}