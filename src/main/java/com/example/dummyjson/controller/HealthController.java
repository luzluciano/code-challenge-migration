package com.example.dummyjson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador responsável por gerenciar as requisições relacionadas à saúde do microsserviço.
 * 
 * O HealthController fornece um endpoint que pode ser utilizado para verificar se o
 * serviço está ativo e funcionando corretamente.
 */
@RestController
public class HealthController {
	/**
     * Endpoint que retorna o status de saúde do serviço.
     * 
     * Este método é mapeado para o caminho "/health". Quando uma requisição GET é
     * feita para esse endpoint, ele retorna uma resposta simples indicando que o
     * serviço está operacional.
     *
     * @return Uma string "OK", indicando que o serviço está saudável.
     */
    @GetMapping("/health")
    public String health() {
        return "OK"; 
    }
}
