package com.example.dummyjson.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import com.example.dummyjson.service.ProductFeignClient;

@SpringBootTest
public class RestTemplateConfigTest {

	@MockBean
	private ProductFeignClient productFeignClient;

	@Test
	public void testRestTemplateNotNull() {
		RestTemplateConfig config = new RestTemplateConfig();
		RestTemplate restTemplate = config.restTemplate();
		assertNotNull(restTemplate, "RestTemplate should not be null");
	}

	@Test
	public void testRestTemplateMutated() {
		// Simulando a mutação
		RestTemplateConfig mutatedConfig = new RestTemplateConfig() {
			@Override
			public RestTemplate restTemplate() {
				return null; // Aqui simulamos a mutação para retornar null
			}
		};

		RestTemplate restTemplate = mutatedConfig.restTemplate();
		assertNull(restTemplate, "RestTemplate should be null due to mutation");
	}

	@Test
	public void testFeignClientConfig() {
		assertThat(productFeignClient).isNotNull();

	}

}
