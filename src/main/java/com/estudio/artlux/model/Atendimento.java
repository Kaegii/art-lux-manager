package com.estudio.artlux.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Atendimento {
    private String descricao;
    private LocalDate dataAtendimento;
    private BigDecimal valor;


    @ManyToOne // muitos atendimentos para um cliente
    @JoinColumn(name = "cliente_id") // nome da chave estrangeira criada no banco
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private TipoAtendimento tipo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public String getDescricao(){
        return this.descricao;
    }

    public LocalDate getDataAtendimento() {
        return this.dataAtendimento;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public Long getId() {
        return this.id;
    }

    public TipoAtendimento getTipo(){ return this.tipo; }

    public Cliente getCliente(){ return this.cliente; }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setTipo(TipoAtendimento tipo){ this.tipo = tipo; }

    public void setCliente(Cliente cliente){ this.cliente = cliente; }
}
