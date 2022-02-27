package com.paycore.CreditSystem.model.mapper;

import com.paycore.CreditSystem.model.DTO.CustomerDTO;
import com.paycore.CreditSystem.model.entity.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDTO toDto(Customer entity);

    Customer toEntity(CustomerDTO dto);

}

