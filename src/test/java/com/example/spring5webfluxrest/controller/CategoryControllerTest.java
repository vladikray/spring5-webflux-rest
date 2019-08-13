package com.example.spring5webfluxrest.controller;


import com.example.spring5webfluxrest.domain.Category;
import com.example.spring5webfluxrest.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CategoryControllerTest {

  WebTestClient webTestClient;
  CategoryRepository categoryRepository;
  CategoryController categoryController;


  @Before
  public void setUp(){
    categoryRepository = Mockito.mock(CategoryRepository.class);
    categoryController = new CategoryController(categoryRepository);
    webTestClient = WebTestClient.bindToController(categoryController).build();
  }


  @Test
  public void findAllTest() {
    Category category = new Category();
    category.setDescription("descritpion");
    Category category2 = new Category();
    category2.setDescription("descritpion");
    BDDMockito.given(categoryRepository.findAll())
        .willReturn(Flux.just(category, category2));

    webTestClient.get()
        .uri("/api/v1/categories")
        .exchange()
        .expectBodyList(Category.class)
        .hasSize(2);
  }


  @Test
  public void findById() {
    Category category = new Category();
    category.setId("id");
    category.setDescription("descritpion");
    BDDMockito.given(categoryRepository.findById(Mockito.anyString()))
        .willReturn(Mono.just(category));

    webTestClient.get()
        .uri("/api/v1/categories/id")
        .exchange()
        .expectBody(Category.class);
  }

}
