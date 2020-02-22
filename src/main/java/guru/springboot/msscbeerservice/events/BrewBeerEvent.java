package guru.springboot.msscbeerservice.events;

import sfg.brewery.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {

  public BrewBeerEvent(BeerDto beerDto) {
    super(beerDto);
  }
}