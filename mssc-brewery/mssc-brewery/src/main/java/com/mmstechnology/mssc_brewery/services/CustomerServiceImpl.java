package com.mmstechnology.mssc_brewery.services;

import com.mmstechnology.mssc_brewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Override
    public CustomerDto getCustomerById(UUID customerId) {



        return CustomerDto.builder().customerId(UUID.randomUUID()).customerName("Martin").build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {

    }

    @Override
    public void deleteById(UUID customerId) {

    }
}
