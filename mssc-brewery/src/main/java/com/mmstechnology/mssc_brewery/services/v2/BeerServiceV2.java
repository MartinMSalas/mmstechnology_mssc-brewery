package com.mmstechnology.mssc_brewery.services.v2;

import com.mmstechnology.mssc_brewery.web.model.BeerDto;
import com.mmstechnology.mssc_brewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {

    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

    BeerDtoV2 updateBeerById(UUID beerId, BeerDtoV2 beerDto);

    void deleteById(UUID beerId);
}
