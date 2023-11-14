package com.simple.bank.api;

import com.simple.bank.dto.CustomerDto;
import com.simple.bank.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void saveNew(@RequestBody CustomerDto customerDto) {
        customerService.save(customerDto);
    }

    @GetMapping
    public Optional<CustomerDto> findByLogin(@RequestParam("login") String login) {
        return customerService.findByLogin(login);
    }
}
