package br.com.ordemservico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ordemservico.dto.AtendimentoStatusFechadoTecnicoDTO;
import br.com.ordemservico.dto.AtendimentoStatusTecnicoDTO;
import br.com.ordemservico.dto.NumeroAtendimentoDTO;
import br.com.ordemservico.dto.OrdemServicoTecnicoAtendimentoDTO;
import br.com.ordemservico.dto.OrdemServicoTecnicoSemAtendimentoDTO;
import br.com.ordemservico.dto.TipoServicoAtendimentosDTO;
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
		
		
		@Query("SELECT new br.com.ordemservico.dto.AtendimentoStatusFechadoTecnicoDTO("
				+ "obj.os.id , obj.os.titulo, obj.os.prioridade, obj.os.cliente.nome, obj.funcionario.nome) "
				+ "FROM Atendimento obj "
				+ "WHERE obj.os.status = :status AND obj.funcionario.nome = :nome")
		List<AtendimentoStatusFechadoTecnicoDTO> findByStatusFechadoTecnicoSQL(int status, String nome);
		
		
		
		//SELECT  o.id, o.status,  f.nome FROM   tb_ordem_servico o,  tb_atendimento a, tb_funcionario f WHERE  o.id = a.id_os_fk  AND o.status = 1
				//SELECT ei.numero_serie, e.marca FROM tb_equipamento_item ei, tb_equipamento e WHERE ei.id_equipamento_fk = e.id AND e.marca = 'Dellamed'
					@Query("SELECT new br.com.ordemservico.dto.OrdemServicoTecnicoAtendimentoDTO("
							+ "obj.funcionario.nome, obj.os.id ,obj.os.status) "
							+ "FROM Atendimento obj "
							+ "WHERE obj.os.status = :status")
					List<OrdemServicoTecnicoAtendimentoDTO> findByTecnicoAtendimentoSQL(int status);
	
					
					@Query("SELECT new br.com.ordemservico.dto.OrdemServicoTecnicoSemAtendimentoDTO("
							+ "obj.funcionario.nome ,obj.os.status) "
							+ "FROM Atendimento obj "
							+ "WHERE obj.os.status != 1")
					List<OrdemServicoTecnicoSemAtendimentoDTO> findByTecnicoSemAtendimentoSQL(int status);

					
					//SELECT t.nome, COUNT(a.id_atendimento) AS numero_de_atendimentos
				//	FROM tecnicos t
				//	LEFT JOIN atendimentos a ON t.id_tecnico = a.id_tecnico
					//GROUP BY t.nome;
					@Query("SELECT new br.com.ordemservico.dto.NumeroAtendimentoDTO(" +
				            "obj.funcionario.nome, COUNT(obj.id)) " +
				            "FROM Atendimento obj " +
				            "WHERE obj.funcionario.nome = :nome " )
				     
				    List<NumeroAtendimentoDTO> findByNumeroAtendimentoSQL(String nome);
				

					
					//Atendimentos com maior numero de tipos
					//@Query(value = "SELECT  new br.com.ordemservico.dto.TipoServicoAtendimentosDTO("
					//		+ " tipo_servico, COUNT(tipo_servico) AS total " +
				    //        "FROM ordemServico " +
				    //        "GROUP BY tipo_servico " +
				    //        "ORDER BY total DESC " +
				    //        "LIMIT 3")
				    //List<TipoServicoAtendimentosDTO>findByTipoServicoAtendimentosSQL();
					
					
		//	*****************************************************************************************		
					//Tempo para atendimento
					
				// @Query(value = new br.com.ordemservico.dto.TesteDTO("
					//SELECT id, TIMESTAMPDIFF(SECOND, dataAbertura, dataFechamento) AS diferenca_tempo
					//FROM OrdemServico")
					
				 //   List<TesteDT> ();



}
