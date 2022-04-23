package com.paycore.CreditSystem.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    private String identityno;
    private String firstname;
    private String lastname;
    private Integer salary;
    private String phone;

}
