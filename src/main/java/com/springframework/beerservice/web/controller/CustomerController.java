package com.springframework.beerservice.web.controller;

import com.springframework.beerservice.web.model.CustomerDto;
import com.springframework.beerservice.web.services.CustomerServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){

        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewCustomer(@RequestBody CustomerDto customerDto){

        CustomerDto saveCustomer = customerService.saveNewCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Locations","/api/v1/customer/"+saveCustomer.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);

    }

    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto){

        customerService.updateCustomer(customerId,customerDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId){

        customerService.deleteCustomerById(customerId);
    }

}
