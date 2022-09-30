package com.dev.backend.service;

import com.dev.backend.entity.Cidade;
import com.dev.backend.entity.Permissao;
import com.dev.backend.repository.CidadeRepository;
import com.dev.backend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    // Buscar todos
    public List<Permissao> buscarTodos(){
        return permissaoRepository.findAll();
    }

    // Save
    public Permissao inserir(Permissao permissao){
        permissao.setDataCriacao(new Date());
        Permissao permissaoNovo = permissaoRepository.saveAndFlush(permissao);
        return permissaoNovo;
    }

    // Update
    public Permissao alterar(Permissao objeto){
        objeto.setDataAtualizacao(new Date());
        return permissaoRepository.saveAndFlush(objeto);
    }

    // Delete id
    public void excluir(Long id){
        Permissao permissao = permissaoRepository.findById(id).get();
        permissaoRepository.delete(permissao);
    }

}