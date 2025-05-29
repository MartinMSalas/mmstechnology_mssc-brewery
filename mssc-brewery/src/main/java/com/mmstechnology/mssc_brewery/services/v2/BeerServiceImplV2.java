package com.mmstechnology.mssc_brewery.services.v2;


import com.mmstechnology.mssc_brewery.web.model.BeerDto;
import com.mmstechnology.mssc_brewery.web.model.v2.BeerDtoV2;
import com.mmstechnology.mssc_brewery.web.model.v2.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImplV2 implements BeerServiceV2 {

    public BeerDtoV2 getBeerById(UUID beerId) {

        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.ALE)
                .upc(123456789012L)
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {




        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.AMBER_ALE)
                .upc(123456789012L)
                .build();
    }

    @Override
    public BeerDtoV2 updateBeerById(UUID beerId, BeerDtoV2 beerDto) {
        // Simulate updating the beer object
        // TODO: every field of beerDto that is not null will be updated, else use the existing value
        BeerDtoV2 updatedBeer = BeerDtoV2.builder()
                .id(beerId)
                .beerName(beerDto.getBeerName())
                .beerStyle(BeerStyleEnum.BARLEYWINE)
                .upc(beerDto.getUpc())
                .build();



        return updatedBeer;
    }


    public void deleteById(UUID beerId) {

        System.out.println("Deleted Beer ID: " + beerId);
    }
}
