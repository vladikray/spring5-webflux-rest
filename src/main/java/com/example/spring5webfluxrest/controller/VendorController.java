package com.example.spring5webfluxrest.controller;

import com.example.spring5webfluxrest.domain.Vendor;
import com.example.spring5webfluxrest.repository.VendorRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@RequestMapping("api/v1/vendors")
@RestController
public class VendorController {

  private final VendorRepository vendorRepository;

  @GetMapping
  public Flux<Vendor> findAll() {
    return vendorRepository.findAll();
  }


  @GetMapping("/{id}")
  public Mono<Vendor> findById(@PathVariable String id) {
    return vendorRepository.findById(id);
  }

}
