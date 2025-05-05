package com.mmstechnology.mssc_brewery.services;


import com.mmstechnology.mssc_brewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {

    public BeerDto getBeerById(UUID beerId) {

        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .upc(123456789012L)
                .build();
    }

    public String saveNewBeer(String beer) {
        return "Saved Beer: " + beer;
    }

    public String updateBeer(String beerId, String beer) {
        return "Updated Beer ID: " + beerId + ", Beer: " + beer;
    }

    public void deleteById(String beerId) {
        System.out.println("Deleted Beer ID: " + beerId);
    }
}
