package com.paycore.CreditSystem.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDTO {
    private Integer credit_limit;
    private String credit_result;
    //*********IGNORE CUSTOMER***********************************************************************
    @JsonIgnore
    private CustomerDTO customer;
}