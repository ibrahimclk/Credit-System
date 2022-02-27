package com.paycore.CreditSystem.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmsService {

    public Boolean sms(String phone, Boolean status){
        if(status){
            log.info("SMS : Credit has been approved.");
        }
        else{
            log.info("SMS : Credit has not been approved.");
        }
        return true;
    }

}
