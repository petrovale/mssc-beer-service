package guru.springboot.msscbeerservice.services;

import guru.sfg.brewery.model.BeerDto;
import guru.sfg.brewery.model.BeerPagedList;
import guru.sfg.brewery.model.BeerStyleEnum;
import java.util.UUID;
import org.springframework.data.domain.PageRequest;

public interface BeerService {
  BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest,
      Boolean showInventoryOnHand);

  BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

  BeerDto saveNewBeer(BeerDto beerDto);

  BeerDto updateBeer(UUID beerId, BeerDto beerDto);

  BeerDto getByUpc(String upc);
}
