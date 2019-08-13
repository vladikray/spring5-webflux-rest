package com.example.spring5webfluxrest.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Category {

  private String id;

  private String description;

}
