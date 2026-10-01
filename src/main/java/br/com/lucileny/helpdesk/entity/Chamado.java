package br.com.lucileny.helpdesk.entity;

import br.com.lucileny.helpdesk.enums.Prioridade;
import br.com.lucileny.helpdesk.enums.StatusChamado;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity

public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;


    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    private StatusChamado status = StatusChamado.ABERTO;

    public Chamado (){

    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setStatus(StatusChamado status) {
        this.status = status;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }
}


