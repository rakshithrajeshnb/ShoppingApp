package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
//	@Query("select p from Product p where p.productPrice between ?1 and ?2")
//	public List<Product> getAllProductsBetween(int initialPrice,int finalPrice);
	
	public List<Product> findByProductPriceBetween(int totalPrice,int finalPrice);
	public List<Product> findByProductCategory(String category);
	public List<Product> findByProductCategoryAndProductPriceLessThan(String category, int price);

}
