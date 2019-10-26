package guru.springboot.msscbeerservice.events;

import guru.springboot.msscbeerservice.web.model.BeerDto;

public class NewInventoryEvent extends BeerEvent {
  public NewInventoryEvent(BeerDto beerDto) {
    super(beerDto);
  }
}