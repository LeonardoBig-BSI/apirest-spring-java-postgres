package com.produtos.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.repository.ProdutoRepository;
import com.produtos.apirest.modelo.ProdutoModelo;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController 
{
    @Autowired
    ProdutoRepository produtoRepository;
    
    // Listar todos os produtos
    @GetMapping("/listar")
    public List<ProdutoModelo> listaProduto() {
        return produtoRepository.findAll();
    }

    // Listar apenas um produto específico
    @GetMapping("/produto/{id}")
    public ProdutoModelo listaProdutoUnico(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);
    }

    // Cadastrar um produto
    @PostMapping("/cadastrar")
    public ProdutoModelo cadastrarProduto(@RequestBody ProdutoModelo produtoModelo) {
        return produtoRepository.save(produtoModelo);
    }

    // Remover um produto
    @DeleteMapping("/remover")
    public void removerProduto(@RequestBody ProdutoModelo produtoModelo) {
        produtoRepository.delete(produtoModelo);
    }

    // Remover um produto pelo ID
    @DeleteMapping("/remover/{id}")
    public void removerProdutoID(@PathVariable(value = "id") long id) {
        produtoRepository.deleteById(id);
    }

    // Alterar um produto
    @PutMapping("/alterar")
    public ProdutoModelo alterarProduto(@RequestBody ProdutoModelo produtoModelo) {
        return produtoRepository.save(produtoModelo);
    }
}
