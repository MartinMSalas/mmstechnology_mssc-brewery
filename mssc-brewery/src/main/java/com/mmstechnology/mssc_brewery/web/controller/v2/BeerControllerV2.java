package com.mmstechnology.mssc_brewery.web.controller.v2;

import com.mmstechnology.mssc_brewery.services.BeerService;
import com.mmstechnology.mssc_brewery.services.BeerServiceImpl;
import com.mmstechnology.mssc_brewery.services.v2.BeerServiceV2;
import com.mmstechnology.mssc_brewery.web.model.BeerDto;
import com.mmstechnology.mssc_brewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping("api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;


    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }


    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeerById(@PathVariable("beerId") UUID beerId) {

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
    public ResponseEntity<BeerDtoV2> saveNewBeer(@RequestBody BeerDtoV2 beerDto) {
        // Simulate saving the beer object
        BeerDtoV2 savedBeer = beerService.saveNewBeer(beerDto);
        log.info("Saved Beer: " + savedBeer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());
        return new ResponseEntity<>(savedBeer,headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BeerDtoV2> updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto) {
        // Simulate updating the beer object
        BeerDtoV2 updatedBeer = beerService.getBeerById(beerId);
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
