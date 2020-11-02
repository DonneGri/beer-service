package com.springframework.beerservice.web.services;

import com.springframework.beerservice.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(customerId)
                                    .name("Bob")
                                    .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                          .id(UUID.randomUUID())
                          .name(customerDto.getName())
                          .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {

        log.info("Updating customer...");
    }

    @Override
    public void deleteCustomerById(UUID customerId) {

        log.info("Deleting customer...");

    }
}
