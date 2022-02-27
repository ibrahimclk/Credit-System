package com.paycore.CreditSystem.model.mapper;

import com.paycore.CreditSystem.model.DTO.ApplicationDTO;
import com.paycore.CreditSystem.model.entity.Application;
import com.paycore.CreditSystem.model.entity.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface ApplicationMapper {

    ApplicationDTO toDto(Application entity);

    Application toEntity(Customer dto);


}
