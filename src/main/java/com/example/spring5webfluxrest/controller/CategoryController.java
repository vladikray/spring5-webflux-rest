package com.example.spring5webfluxrest.controller;

import com.example.spring5webfluxrest.domain.Category;
import com.example.spring5webfluxrest.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
