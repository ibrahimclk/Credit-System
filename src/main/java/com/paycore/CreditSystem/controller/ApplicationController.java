package com.paycore.CreditSystem.controller;

import com.paycore.CreditSystem.model.DTO.ApplicationDTO;
import com.paycore.CreditSystem.model.entity.Application;
import com.paycore.CreditSystem.model.mapper.ApplicationMapper;
import com.paycore.CreditSystem.service.ApplicationService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/application")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ApplicationMapper applicationMapper;

    @ApiOperation(value = "Get all applications")
    @GetMapping(value = "/all")
    public List<ApplicationDTO> getAllApplications(){
        List<Application> allApplications = applicationService.getAllApplications();
        return applicationMapper.toDtos(allApplications);

    }

    @ApiOperation(value = "Get application by id")
    @GetMapping("/get/{identityno}")
    public ApplicationDTO getStatus(@PathVariable("identityno") String identityno) {
        return applicationMapper.toDto(applicationService.getStatus(identityno));
    }


}
