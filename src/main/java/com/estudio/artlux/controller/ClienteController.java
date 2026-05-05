package com.estudio.artlux.controller;

import com.estudio.artlux.model.Cliente;
import com.estudio.artlux.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public String paginaClientes(Model model){

        // adicionamos os clientes do repositório na "mochila" do model
        model.addAttribute("clientes", clienteRepository.findAll());

        return "clientes";
    }

    @PostMapping("/clientes/salvar")
    public String salvarCliente(Cliente cliente){
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()){
            System.out.println("ERRO: insira um nome válido!");
            return "redirect/clientes";
        }

        if (cliente.getDataNascimento() == null){
            System.out.println("ERRO: escolha uma data válida!");
            return "redirect/clientes";
        }
        // salva no banco
        clienteRepository.save(cliente);

        System.out.println("Cliente " + cliente.getID() + " salvo!");

        // funciona como um refresh na página
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/deletar/{id}")
    public String deletarCliente(@PathVariable Long id){
        clienteRepository.deleteById(id);

        return "redirect:/clientes";
    }

}
