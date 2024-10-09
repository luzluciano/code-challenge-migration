package com.example.dummyjson.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dummyjson.dto.Product;

@FeignClient(name = "product", url ="${dummyjson.api.url}")
public interface ProductFeignClient {
	
	 @GetMapping("/{param1}")
	  Product getProductById(@PathVariable("param1") Long param1);

	 @GetMapping("/")
	 Product[] getAllProducts();
	 
}
