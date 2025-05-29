package com.mmstechnology.mssc_brewery.services;

import com.mmstechnology.mssc_brewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {


    @Override
    public CustomerDto getCustomerById(UUID customerId) {



        return CustomerDto.builder().customerId(UUID.randomUUID()).customerName("Martin").build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        log.info("Saving new customer: {}", customerDto);
        if(customerDto.getCustomerId() != null){
            customerDto.setCustomerId(customerDto.getCustomerId());
        }else {
            customerDto.setCustomerId(UUID.randomUUID());
        }
        if(customerDto.getCustomerName() != null) {
            customerDto.setCustomerName(customerDto.getCustomerName());
        }else {
            customerDto.setCustomerName("Martin");
        }
        log.info("Saved Customer: {}", customerDto);


        return customerDto;
    }

    @Override
    public CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto) {
        customerDto.setCustomerId(customerId);
        log.info("Updated Customer: {}", customerDto);
        return customerDto;
    }

    @Override
    public void deleteById(UUID customerId) {
        log.info("Deleted customer with ID: {}", customerId);

    }
}
