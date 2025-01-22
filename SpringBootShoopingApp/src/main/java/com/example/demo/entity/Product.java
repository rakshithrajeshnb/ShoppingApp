package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table

public class Product {
	@Id
	private int productId;
	private String productName;
	private int productPrice;
	private String productCategory;
	private Date productValidity;
}
