package br.com.ordemservico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ordemservico.dto.AtendimentoStatusTecnicoDTO;
import br.com.ordemservico.dto.OrdemServicoTecnicoAtendimentoDTO;
import br.com.ordemservico.entities.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

	
	

//SELECT o.titulo, f.nome FROM tb_atendimento a, tb_ordem_servico o, tb_funcionario f WHERE a.id_os_fk = o.id AND a.id_funcionario_fk = f.id AND o.status= 0 AND f.nome= 'Sakuragi Hanamich';
	//SELECT ei.numero_serie, e.marca FROM tb_equipamento_item ei, tb_equipamento e WHERE ei.id_equipamento_fk = e.id AND e.marca = 'Dellamed'
		@Query("SELECT new br.com.ordemservico.dto.AtendimentoStatusTecnicoDTO("
				+ "obj.os.id , obj.os.titulo, obj.os.prioridade, obj.os.cliente.nome, obj.funcionario.nome) "
				+ "FROM Atendimento obj "
				+ "WHERE obj.os.status = :status AND obj.funcionario.nome = :nome")
		List<AtendimentoStatusTecnicoDTO> findByStatusTecnicoSQL(int status, String nome);
		
		//SELECT  o.id, o.status,  f.nome FROM   tb_ordem_servico o,  tb_atendimento a, tb_funcionario f WHERE  o.id = a.id_os_fk  AND o.status = 1
				//SELECT ei.numero_serie, e.marca FROM tb_equipamento_item ei, tb_equipamento e WHERE ei.id_equipamento_fk = e.id AND e.marca = 'Dellamed'
					@Query("SELECT new br.com.ordemservico.dto.OrdemServicoTecnicoAtendimentoDTO("
							+ "obj.funcionario.nome, obj.os.id ,obj.os.status) "
							+ "FROM Atendimento obj "
							+ "WHERE obj.os.status = :status")
					List<OrdemServicoTecnicoAtendimentoDTO> findByTecnicoAtendimentoSQL(int status);
	
}
