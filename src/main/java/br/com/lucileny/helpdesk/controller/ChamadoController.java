package br.com.lucileny.helpdesk.controller;

import br.com.lucileny.helpdesk.entity.Chamado;
import br.com.lucileny.helpdesk.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping ("/api/chamados")
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService){
        this.chamadoService = chamadoService;


    }
    @PostMapping
    public Chamado cadastrarChamado(@Valid @RequestBody Chamado chamadoNovo){

        return chamadoService.cadastrarChamado(chamadoNovo);
    }
    @GetMapping("/{id}")
    public Chamado consultarChamado(@PathVariable Long id){

            return chamadoService.consultarChamado(id) ;
    }
    @GetMapping
    public List<Chamado> listarchamados(){

        return chamadoService.listarChamados();
    }

    @DeleteMapping ("/{id}")
    public void deletarChamado(@PathVariable Long id){

        chamadoService.deletarChamado(id);

    }
    @PutMapping  ("/{id}")
    public Chamado editarChamado(@PathVariable Long id, @Valid @RequestBody Chamado chamadoEditado ){


        return  chamadoService.editarChamado(id,chamadoEditado);
    }
    @PatchMapping ("/{id}")
    public Chamado editarChamadoParcial(@PathVariable Long id, @RequestBody Chamado chamadoEditado ){


        return  chamadoService.editarChamadoParcial(id,chamadoEditado);
    }
}

