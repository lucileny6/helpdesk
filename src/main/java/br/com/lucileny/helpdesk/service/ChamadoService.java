package br.com.lucileny.helpdesk.service;

import br.com.lucileny.helpdesk.entity.Chamado;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import br.com.lucileny.helpdesk.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class ChamadoService {
    private final ChamadoRepository chamadoRepository;

    public ChamadoService( ChamadoRepository chamadoRepository){
        this.chamadoRepository = chamadoRepository;

    }
    public Chamado cadastrarChamado( Chamado chamadoNovo){

        if(chamadoNovo == null){
            throw new IllegalArgumentException("objeto não existe");
        }

        String titulo = chamadoNovo.getTitulo();
        if( titulo == null ||  titulo.isBlank() ) {
            throw new IllegalArgumentException("O Titulo é obrigatorio");
        }

        String descricao = chamadoNovo.getDescricao();
        if (descricao == null || descricao.isBlank()){
            throw new IllegalArgumentException("A Descrição é obrigatorio");
        }

        if (chamadoNovo.getPrioridade() == null){
            throw new IllegalArgumentException("A prioridade é obrigatoria");

        }


        return chamadoRepository.save(chamadoNovo);
    }
    public Chamado  consultarChamado(long id){

        return chamadoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Chamado não encontrado com o ID: " + id));


    }
    @Autowired

    public List <Chamado> listarChamados(){


        return  chamadoRepository.findAll();

    }

    public void deletarChamado(Long id){
        Chamado chamado =  chamadoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Chamado não encontrado com o ID: " + id));
        chamadoRepository.delete(chamado);

    }
    public Chamado editarChamado(Long id , Chamado chamadoEditado) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Chamado não encontrado com o ID: " + id));

        chamado.setStatus(chamadoEditado.getStatus());
        chamado.setPrioridade(chamadoEditado.getPrioridade());
        chamado.setTitulo(chamadoEditado.getTitulo());
        chamado.setDescricao(chamadoEditado.getDescricao());

        return chamadoRepository.save(chamado);

    }
    public Chamado editarChamadoParcial(Long id , Chamado chamadoEditado) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Chamado não encontrado com o ID: " + id));

       if (chamadoEditado.getTitulo() !=null){
           chamado.setTitulo(chamadoEditado.getTitulo());
       }
       if (chamadoEditado.getStatus() !=null){
           chamado.setStatus(chamadoEditado.getStatus());
        }
       if (chamadoEditado.getPrioridade() !=null){
           chamado.setPrioridade(chamadoEditado.getPrioridade());
       }
       if (chamadoEditado.getDescricao() !=null){
           chamado.setDescricao(chamadoEditado.getDescricao());
       }


        return chamadoRepository.save(chamado);

    }
}
