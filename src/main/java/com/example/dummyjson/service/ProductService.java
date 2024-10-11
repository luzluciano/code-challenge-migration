package com.example.dummyjson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dummyjson.dto.ListProduct;
import com.example.dummyjson.dto.Product;

@Service
public class ProductService {
	@Autowired
	private ProductFeignClient productFeignClient;

	public List<Product> getAllProducts() {
		
		ListProduct listProducts = productFeignClient.getAllProductsList();
		return listProducts.getProducts();
		
		//Product[] products = (Product[]) listProducts.getProducts().toArray();
		//return Arrays.asList(products);
	}

	public Product getProductById(Long id) {
		return productFeignClient.getProductById(id);

	}
}
