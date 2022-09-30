package com.dev.backend.controller;
import com.dev.backend.entity.Cidade;
import com.dev.backend.entity.Estado;
import com.dev.backend.service.CidadeService;
import com.dev.backend.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/cidade")
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    // search all buscar todos
    @GetMapping("/")
    public List<Cidade> buscarTodos(){
        return cidadeService.buscarTodos();
    }

    // Insert a new Object
    @PostMapping("/")
    public Cidade inserir(@RequestBody Cidade objeto){
        return cidadeService.inserir(objeto);
    }

    // Uppdate Alterar
    @PutMapping("/")
    public Cidade alterar(@RequestBody Cidade objeto){
        return cidadeService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        cidadeService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
