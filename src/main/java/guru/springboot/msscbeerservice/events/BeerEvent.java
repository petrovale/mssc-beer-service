package guru.springboot.msscbeerservice.events;

import guru.springboot.msscbeerservice.web.model.BeerDto;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {

  static final long serialVersionUID = -5781515597148163111L;

  private final BeerDto beerDto;
}