package com.mmstechnology.mssc_brewery.web.controller;

import com.mmstechnology.mssc_brewery.services.BeerService;
import com.mmstechnology.mssc_brewery.services.BeerServiceImpl;
import com.mmstechnology.mssc_brewery.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RequestMapping("api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }


    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {

        // Simulate a beer object
        BeerDto beerDto = BeerDto.builder()
                .id(beerId)
                .beerName("Beer Name")
                .beerStyle("IPA")
                .upc(123456789012L)
                .build();

        //return ResponseEntity.ok(beerDto);

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }
}
