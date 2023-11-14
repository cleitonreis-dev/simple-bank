package com.simple.bank.transformer;

import com.simple.bank.dto.CustomerDto;
import com.simple.bank.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerTransformer {

    public Customer toCustomer(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setLogin(dto.getLogin());
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        return customer;
    }

    public CustomerDto toCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setLogin(customer.getLogin());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setCreatedAt(customer.getCreatedAt());
        return customerDto;
    }
}
