package com.springframework.beerservice.web.controller;

import com.springframework.beerservice.web.model.BeerDto;
import com.springframework.beerservice.web.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto>getBeerById(@PathVariable("beerId")UUID beerId){

        return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto){

        BeerDto saveDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer/" + saveDto.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);

    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId,@RequestBody BeerDto beerDto){

        beerService.updateBeer(beerId,beerDto);

        return new ResponseEntity(HttpStatus.OK);

    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);
    }

}
