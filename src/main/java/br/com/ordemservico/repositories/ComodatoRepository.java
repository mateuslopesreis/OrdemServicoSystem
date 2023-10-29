package br.com.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ordemservico.entities.Comodato;

@Repository
public interface ComodatoRepository extends JpaRepository<Comodato, Long>{

}
