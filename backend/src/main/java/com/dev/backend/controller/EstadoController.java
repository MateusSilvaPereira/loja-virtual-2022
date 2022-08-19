package com.dev.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class EstadoController {

    @GetMapping("/")
    public String index(){
        return "Olá mundo! " + new Date();
    }
}
