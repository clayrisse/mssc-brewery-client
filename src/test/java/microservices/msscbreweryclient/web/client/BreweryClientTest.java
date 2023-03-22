package microservices.msscbreweryclient.web.client;

import microservices.msscbreweryclient.web.model.BeerDto;
import microservices.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("new beer").build();
        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.err.println(uri.toString());
    }

    @Test
    void updateBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("new beer").build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteBeer() {
        //given
        client.deleteBeer(UUID.randomUUID());
    }

    //------------Customer

    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("new customer").build();
        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.err.println(uri.toString());
    }

    @Test
    void updateCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("new customer").build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        //given
        client.deleteBeer(UUID.randomUUID());
    }

}