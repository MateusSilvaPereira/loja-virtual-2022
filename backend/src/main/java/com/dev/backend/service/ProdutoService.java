package com.dev.backend.service;

import com.dev.backend.entity.Produto;
import com.dev.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    public Produto inserir(Produto produto){
        produto.setDataCriacao(new Date());
        Produto novoProduto= produtoRepository.saveAndFlush(produto);
        return novoProduto;
    }

    public Produto alterar(Produto produto){
        produto.setDataAtualizacao(new Date());
        return produtoRepository.save(produto);
    }

    public void excluir(Long id){
        Produto objeto = produtoRepository.findById(id).get();
        produtoRepository.delete(objeto);
    }
}
