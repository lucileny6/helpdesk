package br.com.lucileny.helpdesk.repository;

import br.com.lucileny.helpdesk.entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long>{



}
