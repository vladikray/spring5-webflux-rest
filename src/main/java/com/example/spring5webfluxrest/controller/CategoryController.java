package com.example.spring5webfluxrest.controller;

import com.example.spring5webfluxrest.domain.Category;
import com.example.spring5webfluxrest.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

  public final CategoryRepository categoryRepository;

  @GetMapping
  public Flux<Category> getAll(){
    return categoryRepository.findAll();
  }

  @GetMapping("/{id}")
  public Mono<Category> findById(@PathVariable String id) {
    return categoryRepository.findById(id);
  }


  @PostMapping
  public Mono<Void> create(@RequestBody Publisher<Category> categoryPublisher) {
    return categoryRepository.saveAll(categoryPublisher).then();
  }

  @PutMapping("/{id}")
  public Mono<Category> updatePut(@PathVariable String id,@RequestBody Category category) {
    category.setId(id);
    return  categoryRepository.save(category);
  }

}
