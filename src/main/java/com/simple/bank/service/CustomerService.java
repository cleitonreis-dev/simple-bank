package com.simple.bank.service;

import com.simple.bank.dto.CustomerDto;
import com.simple.bank.model.Customer;
import com.simple.bank.repository.CustomerRepository;
import com.simple.bank.transformer.CustomerTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository repository;
    private final CustomerTransformer transformer;

    public CustomerService(CustomerRepository repository, CustomerTransformer transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    @Transactional
    public void save(CustomerDto customerDto) {
        log.info("Saving user: {}", customerDto);

        Customer customer = transformer.toCustomer(customerDto);
        customer.setCreatedAt(LocalDateTime.now());
        repository.save(customer);
    }

    public Optional<CustomerDto> findByLogin(String login) {
        Optional<Customer> customer = repository.findById(login);
        return customer.map(transformer::toCustomerDto);
    }
}
