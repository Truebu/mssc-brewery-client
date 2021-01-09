package dev.juandavid.msscbreweryclient.business.client;

import dev.juandavid.msscbreweryclient.model.dto.BeerDto;
import dev.juandavid.msscbreweryclient.model.dto.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "dev.juandavid", ignoreUnknownFields = false)
public class BreweryClient {

    private String apihost;
    public final String BEER_PATH_V1="/api/v1/beer/";
    public final String CUSTOMER_PATH_V1="/api/v1/customer/";
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    //Beer

    public BeerDto getBeerById (UUID uuid){
        return restTemplate.getForObject(apihost+BEER_PATH_V1+uuid.toString(),BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apihost+BEER_PATH_V1,beerDto);

    }

    public void updateBeer(BeerDto beerDto){
        restTemplate.put(apihost+BEER_PATH_V1, beerDto);
    }

    public void deleteById(UUID uuid) {
        restTemplate.delete(apihost+BEER_PATH_V1+"/"+uuid.toString());
    }

    //Customer

    public CustomerDto getCustomer(UUID uuid){
        return restTemplate.getForObject(apihost+CUSTOMER_PATH_V1+uuid.toString(),CustomerDto.class);
    }

    public URI handlePost (CustomerDto customerDto){
        return restTemplate.postForLocation(apihost+CUSTOMER_PATH_V1,customerDto);
    }

    public void handleUpdate(CustomerDto customerDto){
        restTemplate.put(apihost+CUSTOMER_PATH_V1, customerDto);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(apihost+CUSTOMER_PATH_V1+"/"+uuid.toString());
    }

    //

    public void setApiHost (String apihost){
        this.apihost=apihost;
    }
}
