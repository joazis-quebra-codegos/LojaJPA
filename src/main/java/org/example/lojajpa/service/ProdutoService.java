package org.example.lojajpa.service;

import org.example.lojajpa.model.Produto;
import org.example.lojajpa.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }

    public Produto salvar(Produto produto){
        return repository.save(produto);
    }

    public Produto buscar(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não foi encontrado"));
    }

    public List<Produto> listar(){
        return repository.findAll();
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public List<Produto> buscarPorNome(String nome){
        return repository.findByNomeContainingIgnoreCase(nome);
    }
}
