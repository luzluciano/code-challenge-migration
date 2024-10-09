package com.example.dummyjson.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.dummyjson.service.ProductFeignClient;

@SpringBootTest
public class RestTemplateConfigTest {

	@Autowired
    RestTemplateConfig restTemplateConfig;
	
    @MockBean
	private ProductFeignClient productFeignClient;

    @Test
    public void testRestTemplateConfig(){
    	 assertThat(restTemplateConfig).isNotNull();
       
    }
    
    @Test
    public void testFeignClientConfig(){
    	 assertThat(productFeignClient).isNotNull();
       
    }
}
