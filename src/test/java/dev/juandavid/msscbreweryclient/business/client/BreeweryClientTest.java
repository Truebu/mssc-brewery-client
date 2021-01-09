package dev.juandavid.msscbreweryclient.business.client;

import dev.juandavid.msscbreweryclient.model.dto.BeerDto;
import dev.juandavid.msscbreweryclient.model.dto.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreeweryClientTest {

    @Autowired
    BreweryClient breeweryClient;

    //beer

    @Test
    void getBeerById() {
        BeerDto dto= breeweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer(){
        BeerDto beerDto=BeerDto.builder().beerName("New Beer").build();
        URI uri =breeweryClient.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateBeer(){
        BeerDto beerDto=BeerDto.builder().beerName("New Beer").id(UUID.randomUUID()).build();
        breeweryClient.updateBeer(beerDto);
    }

    @Test
    void deleteById(){
        breeweryClient.deleteById(UUID.randomUUID());
    }

    //customer

    @Test
    void getCustomer() {
        CustomerDto dto= breeweryClient.getCustomer(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void handlePost() {
        CustomerDto customerDto=CustomerDto.builder().customName("New customer").build();
        URI uri =breeweryClient.handlePost(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void handleUpdate() {
        CustomerDto customerDto=CustomerDto.builder().customName("New customer").id(UUID.randomUUID()).build();
        breeweryClient.handleUpdate(customerDto);
    }

    @Test
    void deleteCustomer() {
        breeweryClient.deleteCustomer(UUID.randomUUID());
    }

}