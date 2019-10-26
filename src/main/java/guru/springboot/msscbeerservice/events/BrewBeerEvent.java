package guru.springboot.msscbeerservice.events;

import guru.springboot.msscbeerservice.web.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {

  public BrewBeerEvent(BeerDto beerDto) {
    super(beerDto);
  }
}