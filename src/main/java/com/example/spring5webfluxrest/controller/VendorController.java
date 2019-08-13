package com.example.spring5webfluxrest.controller;

import com.example.spring5webfluxrest.domain.Vendor;
import com.example.spring5webfluxrest.repository.VendorRepository;
import lombok.Data;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.*;
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

  @PostMapping
  public Mono<Void> create(@RequestBody Publisher<Vendor> vendorPublisher) {
    return vendorRepository.saveAll(vendorPublisher).then();
  }

  @PutMapping("/{id}")
  public Mono<Vendor> updatePut(@PathVariable String id, @RequestBody Vendor vendor) {
    vendor.setId(id);
    return vendorRepository.save(vendor);
  }

}
