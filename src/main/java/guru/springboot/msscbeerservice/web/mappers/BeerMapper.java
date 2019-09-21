package guru.springboot.msscbeerservice.web.mappers;

import guru.springboot.msscbeerservice.domain.Beer;
import guru.springboot.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

  BeerDto BeerToBeerDto(Beer beer);

  Beer BeerDtoToBeer(BeerDto dto);
}
