package guru.springboot.msscbeerservice.events;

import guru.springboot.msscbeerservice.web.model.BeerDto;

public class BrewBeerEvent extends BeerEvent {

  public BrewBeerEvent(BeerDto beerDto) {
    super(beerDto);
  }
}