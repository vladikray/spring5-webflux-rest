package com.example.spring5webfluxrest.bootstrap;

import com.example.spring5webfluxrest.domain.Category;
import com.example.spring5webfluxrest.domain.Vendor;
import com.example.spring5webfluxrest.repository.CategoryRepository;
import com.example.spring5webfluxrest.repository.VendorRepository;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Data
@Component
public class Bootstrap implements CommandLineRunner {

  private final CategoryRepository categoryRepository;
  private final VendorRepository vendorRepository;


  @Override
  public void run(String... args) throws Exception {
    if(categoryRepository.count().block() == 0) {
      Category category = new Category();
      category.setDescription("some description");

      Category category2 = new Category();
      category2.setDescription("some description");
      categoryRepository.save(category).block();
      categoryRepository.save(category2).block();
    }

    if(vendorRepository.count().block() == 0 ) {
      Vendor vendor = new Vendor();
      vendor.setFirstName("FirstName");
      vendor.setLastName("LastName");
      vendorRepository.save(vendor).block();
    }
  }
}
