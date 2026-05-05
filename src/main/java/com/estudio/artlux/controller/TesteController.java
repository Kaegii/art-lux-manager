package com.estudio.artlux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/boas-vindas")
    public String darBoasVindas(){
        return "O sistema TattooFlow está online!";
    }
}
