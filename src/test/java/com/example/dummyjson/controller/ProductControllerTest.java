package com.example.dummyjson.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {


	@Autowired
	private ProductController productController;

	@MockBean
	private ProductService productService;

	@Test
	public void testGetAllProducts() {
		Product product1 = new Product();
		product1.setId(1L);
		product1.setTitle("Product 1");

		Product product2 = new Product();
		product2.setId(2L);
		product2.setTitle("Product 2");

		List<Product> products = Arrays.asList(product1, product2);
		when(productService.getAllProducts()).thenReturn(products);

		List<Product> result = productController.getAllProducts();
		assertThat(2).isEqualTo(result.size());
		assertThat(result.get(0).getTitle()).isEqualTo("Product 1");

	}

	@Test
	public void testGetProductById() {
		Product product = new Product();
		product.setId(1L);
		product.setTitle("Product 1");

		when(productService.getProductById(1L)).thenReturn(product);

		Product result = productController.getProductById(1L);
		assertThat(result.getTitle()).isEqualTo("Product 1");
	}
}
