package com.paycore.CreditSystem.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ApplicationDTO {
    private Integer credit_limit;
    private String credit_result;
    //*********IGNORE CUSTOMER***********************************************************************
    @JsonIgnore
    private CustomerDTO customer;
}