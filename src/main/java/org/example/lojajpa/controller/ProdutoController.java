package org.example.lojajpa.controller;

import jakarta.validation.Valid;
import org.example.lojajpa.model.Produto;
import org.example.lojajpa.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service){
        this.service = service;
    }

    @GetMapping
    public List<Produto> Listar(){
        return service.listar();
    }

    @PostMapping
    public Produto criar(@RequestBody @Valid Produto produto){
        return service.salvar(produto);
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto){
        produto.setId(id);
        return service.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @GetMapping("/buscar")
    public void buscarPorNome
}
