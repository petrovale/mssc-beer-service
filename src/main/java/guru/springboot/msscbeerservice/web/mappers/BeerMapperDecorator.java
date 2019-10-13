package guru.springboot.msscbeerservice.web.mappers;

import guru.springboot.msscbeerservice.domain.Beer;
import guru.springboot.msscbeerservice.services.inventory.BeerInventoryService;
import guru.springboot.msscbeerservice.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerMapperDecorator implements BeerMapper {

  private BeerInventoryService beerInventoryService;
  private BeerMapper mapper;

  @Autowired
  public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
    this.beerInventoryService = beerInventoryService;
  }

  @Autowired
  public void setMapper(BeerMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public BeerDto beerToBeerDto(Beer beer) {
    BeerDto dto = mapper.beerToBeerDto(beer);
    return dto;
  }

  @Override
  public Beer beerDtoToBeer(BeerDto beerDto) {
    return mapper.beerDtoToBeer(beerDto);
  }

  @Override
  public BeerDto beerToBeerDtoWithInventory(Beer beer) {
    BeerDto dto = mapper.beerToBeerDto(beer);
    dto.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));
    return dto;
  }
}
