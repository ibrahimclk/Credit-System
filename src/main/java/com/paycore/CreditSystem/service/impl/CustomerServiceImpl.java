package com.paycore.CreditSystem.service.impl;

import com.paycore.CreditSystem.exception.NotFoundException;
import com.paycore.CreditSystem.model.entity.Customer;
import com.paycore.CreditSystem.repository.CustomerRepository;
import com.paycore.CreditSystem.service.ApplicationService;
import com.paycore.CreditSystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ApplicationService applicationService;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Integer id) {
        Optional<Customer> byId = customerRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Customer"));
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
        applicationService.makeApplication(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        customerRepository.delete(getCustomer(id));
        return true;
    }
}
