package com.example.dummyjson.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dummyjson.dto.Product;

@Service
public class ProductService {
	@Autowired
	private ProductFeignClient productFeignClient;

	public List<Product> getAllProducts() {

		Product[] products = productFeignClient.getAllProducts();

		return Arrays.asList(products);
	}

	public Product getProductById(Long id) {
		return productFeignClient.getProductById(id);

	}
}
