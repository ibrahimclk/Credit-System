package com.paycore.CreditSystem.service.impl;

import com.paycore.CreditSystem.exception.NotFoundException;
import com.paycore.CreditSystem.model.entity.Application;
import com.paycore.CreditSystem.model.entity.Customer;
import com.paycore.CreditSystem.repository.ApplicationRepository;
import com.paycore.CreditSystem.service.ApplicationService;
import javafx.util.Pair;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ScoreService scoreService;
    private final SmsService smsservice;

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Application getStatus(String identityno) {
        Optional<Application> byId = Optional.ofNullable(applicationRepository.findByCustomerIdentityno(identityno));
        return byId.orElseThrow(() -> new NotFoundException("Application"));
    }

    //rule
    public static int CREDIT_LIMIT_MULTIPLIER = 4;


    @Override
    public Application makeApplication(Customer customer) {
        int score = scoreService.getScore(customer.getIdentityno());
        String result;
        int salary = customer.getSalary();
        int limit;
//        log.info(String.valueOf(score));
        if(score < 500){
            result= "UNCONFIRMED";
            limit = 0;
        }else if(score < 1000 && salary <= 5000){
            result = "CONFIRMED";
            limit = 10000;
        }else if(score < 1000){
            result = "CONFIRMED";
            limit = 20000;
        }else {
            result = "CONFIRMED";
            limit = salary*CREDIT_LIMIT_MULTIPLIER;
        }

        Application application = Application.builder().customer(customer).credit_limit(limit).credit_result(result).build();
        Boolean status = (Objects.equals(application.getCredit_result(), "CONFIRMED"));
        smsservice.sms(customer.getPhone(), status);
        log.info("Service: Sms sending has been completed.");
        return applicationRepository.save(application);
    }
}
