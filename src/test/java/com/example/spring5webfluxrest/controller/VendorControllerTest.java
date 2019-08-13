package com.example.spring5webfluxrest.controller;


import com.example.spring5webfluxrest.domain.Vendor;
import com.example.spring5webfluxrest.repository.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class VendorControllerTest {


  VendorRepository vendorRepository;
  VendorController vendorController;
  WebTestClient webTestClient;


  @Before
  public void setUp(){
    vendorRepository = Mockito.mock(VendorRepository.class);
    vendorController = new VendorController(vendorRepository);
    webTestClient = WebTestClient.bindToController(vendorController).build();
  }


  @Test
  public void findAllTest() {
    Vendor vendor = new Vendor();
    vendor.setFirstName("first");
    vendor.setLastName("last");
    BDDMockito.given(vendorRepository.findAll())
        .willReturn(Flux.just(vendor));

    webTestClient.get()
        .uri("/api/v1/vendors")
        .exchange()
        .expectBodyList(Vendor.class)
        .hasSize(1);
  }


  @Test
  public void findByIdTest() {
    Vendor vendor = new Vendor();
    vendor.setFirstName("first");
    vendor.setLastName("last");
    BDDMockito.given(vendorRepository.findById(Mockito.anyString()))
        .willReturn(Mono.just(vendor));

    webTestClient.get()
        .uri("/api/v1/vendors/id")
        .exchange()
        .expectBody(Vendor.class);
  }

}
