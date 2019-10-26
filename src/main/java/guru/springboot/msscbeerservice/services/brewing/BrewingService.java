package guru.springboot.msscbeerservice.services.brewing;

import guru.springboot.msscbeerservice.config.JmsConfig;
import guru.springboot.msscbeerservice.domain.Beer;
import guru.springboot.msscbeerservice.events.BrewBeerEvent;
import guru.springboot.msscbeerservice.repositories.BeerRepository;
import guru.springboot.msscbeerservice.services.inventory.BeerInventoryService;
import guru.springboot.msscbeerservice.web.mappers.BeerMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {
  private final BeerRepository beerRepository;
  private final BeerInventoryService beerInventoryService;
  private final JmsTemplate jmsTemplate;
  private final BeerMapper beerMapper;

  @Scheduled(fixedRate = 5000) //every 5 seconds
  public void checkForLowInventory(){
    List<Beer> beers = beerRepository.findAll();

    beers.forEach(beer -> {
      Integer invQOH = beerInventoryService.getOnhandInventory(beer.getId());

      log.debug("Min Onhand is: " + beer.getMinOnHand());
      log.debug("Inventory is: "  + invQOH);

      if(beer.getMinOnHand() >= invQOH){
        jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
      }
    });

  }
}
