package com.estudio.artlux.controller;

import com.estudio.artlux.model.Atendimento;
import com.estudio.artlux.model.TipoAtendimento;
import com.estudio.artlux.repository.AtendimentoRepository;
import com.estudio.artlux.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AtendimentoController {
    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/atendimentos")
    public String paginaAtendimentos(Model model){

        // o que o formulário precisa para ser preenchido
        // precisa do "cliente" e do "tipo" do atendimento

        model.addAttribute("tipos", TipoAtendimento.values());
        model.addAttribute("clientes", clienteRepository.findAll());

        // o que a tabela precisa para mostrar os atendimentos existentes
        model.addAttribute("atendimentos", atendimentoRepository.findAll());

        return "atendimentos";
    }

    @PostMapping("/atendimentos/salvar")
    public String salvarAtendimento(Atendimento atendimento){
        if (atendimento.getDataAtendimento() == null){
            System.out.println("ERR0: insira uma data válida!");
            return "redirect:/atendimentos";
        }

        atendimentoRepository.save(atendimento);

        System.out.println("Atendimento " + atendimento.getId() + " criado!");

        return "redirect:/atendimentos";

    }

    @GetMapping("/atendimentos/deletar/{id}")
    public String deletarAtendimento(@PathVariable Long id){
        atendimentoRepository.deleteById(id);

        return "redirect:/atendimentos";
    }

}
