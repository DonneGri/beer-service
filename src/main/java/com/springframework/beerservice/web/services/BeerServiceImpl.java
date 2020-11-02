package com.springframework.beerservice.web.services;

import com.springframework.beerservice.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
class BeerServiceImpl implements  BeerService{

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(beerId)
                    .beerName("Cosmo cat")
                    .price(2.50)
                    .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                      .id(UUID.randomUUID())
                      .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {

    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting a beer...");

    }
}
