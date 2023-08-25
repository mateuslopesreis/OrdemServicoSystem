package br.com.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ordemservico.entities.OrdemServico;


public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

}
