package com.mmstechnology.mssc_brewery.services;


import com.mmstechnology.mssc_brewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {

    public BeerDto getBeerById(UUID beerId) {

        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("PALE_ALE")
                .upc(123456789012L)
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {




        return BeerDto.builder().id(UUID.randomUUID())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .upc(beerDto.getUpc())
                .build();
    }

    @Override
    public BeerDto updateBeerById(UUID beerId, BeerDto beerDto) {
        // Simulate updating the beer object
        // TODO: every field of beerDto that is not null will be updated, else use the existing value
        BeerDto updatedBeer = BeerDto.builder()
                .id(beerId)
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .upc(beerDto.getUpc())
                .build();



        return updatedBeer;
    }


    public void deleteById(UUID beerId) {

        System.out.println("Deleted Beer ID: " + beerId);
    }
}
