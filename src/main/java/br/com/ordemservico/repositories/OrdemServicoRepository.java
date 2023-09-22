package br.com.ordemservico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ordemservico.dto.AtendimentoStatusTecnicoDTO;
import br.com.ordemservico.dto.OrdemServicoTecnicoAtendimentoDTO;
import br.com.ordemservico.entities.OrdemServico;


public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
	
	

}
