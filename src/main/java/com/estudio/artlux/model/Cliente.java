package com.estudio.artlux.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Cliente {
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // o id é gerado automaticamente quando o objeto é criado
    private Long id;

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public String getNome(){
        return this.nome;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public Long getID(){
        return this.id;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
