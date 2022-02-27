package com.paycore.CreditSystem.model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
public class CustomerDTO {

    private String identityno;
    private String firstname;
    private String lastname;
    private Integer salary;
    private String phone;

}
