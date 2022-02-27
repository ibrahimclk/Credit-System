package com.paycore.CreditSystem.model.DTO;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UserLoginDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
