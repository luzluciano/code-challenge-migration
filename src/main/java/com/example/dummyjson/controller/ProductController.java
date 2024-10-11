package com.example.dummyjson.controller;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Controlador responsável por gerenciar as requisições relacionadas aos produtos.
 * 
 * O ProductController fornece endpoints para acessar e manipular informações dos produtos
 * disponíveis na aplicação.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {
    // Injeção de dependência do serviço de produtos
    @Autowired
    private ProductService productService;
    /**
     * Endpoint para recuperar todos os produtos.
     *
     * Este método é mapeado para o caminho "/api/products". Quando uma requisição GET
     * é feita para esse endpoint, ele retorna uma lista de todos os produtos disponíveis.
     *
     * @return Uma lista de objetos Product.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    /**
     * Endpoint para recuperar um produto específico pelo seu ID.
     *
     * Este método é mapeado para o caminho "/api/products/{id}". Quando uma requisição GET
     * é feita para esse endpoint com um ID válido, ele retorna o produto correspondente.
     *
     * @param id O ID do produto a ser recuperado. Este parâmetro não pode ser nulo.
     * @return O objeto Product correspondente ao ID fornecido.
     * @throws NotFoundException Se o produto com o ID fornecido não for encontrado.
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable @NotNull Long id) {
        return productService.getProductById(id);
    }
}
