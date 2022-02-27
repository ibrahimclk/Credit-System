package com.paycore.CreditSystem.model.DTO;

import com.paycore.CreditSystem.model.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {

    private Integer id;
    private String username;
    List<Role> roles;

}
