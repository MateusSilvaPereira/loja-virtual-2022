package com.dev.backend.service;

import com.dev.backend.entity.Cidade;
import com.dev.backend.entity.Marca;
import com.dev.backend.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> buscarTodos(){
        return marcaRepository.findAll();
    }

    public Marca inserir(Marca marca){
        marca.setDataCriacao(new Date());
        Marca novoMarca = marcaRepository.saveAndFlush(marca);
        return novoMarca;
    }

    public Marca alterar(Marca marca){
        marca.setDataAtualizacao(new Date());
        return marcaRepository.save(marca);
    }

    public void excluir(Long id){
        Marca marca = marcaRepository.findById(id).get();
         marcaRepository.delete(marca);
    }
}
