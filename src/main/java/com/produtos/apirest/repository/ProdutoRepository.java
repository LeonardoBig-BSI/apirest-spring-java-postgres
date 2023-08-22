package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.modelo.ProdutoModelo;

public interface ProdutoRepository extends JpaRepository<ProdutoModelo, Long> {
    
    // Método para retornar um produto segundo seu ID
    ProdutoModelo findById(long id);
}
