package com.example.dummyjson.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dummyjson.dto.ListProduct;
import com.example.dummyjson.dto.Product;

/**
 * Interface que define o cliente Feign para interagir com a API de produtos.
 *
 * O Feign é um cliente HTTP declarativo que facilita a comunicação com serviços externos
 * de forma simples e intuitiva. Esta interface é responsável por mapear as requisições
 * HTTP para os endpoints da API que fornecem informações sobre produtos.
 *
 * @FeignClient(name = "product", url ="${dummyjson.api.url}")
 * - Anotação que indica que esta interface é um cliente Feign.
 * - O atributo `name` especifica o nome do cliente, que pode ser usado para configuração e
 *   identificação.
 * - O atributo `url` aponta para a URL base da API, que é parametrizada através de um
 *   valor definido no arquivo de configuração (por exemplo, `application.yml`).
 */

@FeignClient(name = "product", url ="${dummyjson.api.url}")
public interface ProductFeignClient {
    /**
     * Obtém um produto pelo seu ID.
     *
     * Este método faz uma requisição GET para o endpoint da API que retorna um produto
     * específico, identificado pelo seu ID.
     *
     * @param param1 O ID do produto a ser recuperado.
     * @return Um objeto Product correspondente ao ID fornecido.
     */
	 @GetMapping("/{param1}")
	  Product getProductById(@PathVariable("param1") Long param1);
	 
	 
	   /**
	     * Obtém todos os produtos disponíveis.
	     *
	     * Este método faz uma requisição GET para o endpoint da API que retorna todos os
	     * produtos.
	     *
	     * @return Um array de objetos Product representando todos os produtos disponíveis.
	     */
	 @GetMapping("/")
	 Product[] getAllProducts();

	 @GetMapping("/")
	 ListProduct getAllProductsList();
}
