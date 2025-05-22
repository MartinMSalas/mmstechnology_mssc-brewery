package com.mmstechnology.mssc_brewery.web.controller;

import com.mmstechnology.mssc_brewery.services.BeerService;
import com.mmstechnology.mssc_brewery.services.BeerServiceImpl;
import com.mmstechnology.mssc_brewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;


@Slf4j
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



    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@RequestBody BeerDto beerDto) {
        // Simulate saving the beer object
        BeerDto savedBeer = beerService.saveNewBeer(beerDto);
        log.info("Saved Beer: " + savedBeer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());
        return new ResponseEntity<>(savedBeer,headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BeerDto> updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        // Simulate updating the beer object
        BeerDto updatedBeer = beerService.getBeerById(beerId);
        log.info("Updated Beer: {}", updatedBeer);
        return new ResponseEntity<>(updatedBeer, HttpStatus.OK);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerById(@PathVariable("beerId") UUID beerId) {
        // Simulate deleting the beer object
        beerService.deleteById(beerId);
        log.info("Deleted Beer ID: {}", beerId);
    }
}
