package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table
public class Product {
    @Id
    private int productId;

    @NotBlank(message = "Product name is mandatory")
    private String productName;

    @Min(value = 0, message = "Product price must be greater than or equal to 0")
    private int productPrice;

    @NotBlank(message = "Product category is mandatory")
    private String productCategory;

    @FutureOrPresent(message = "Product validity date must be in the present or future")
    private Date productValidity;
}

