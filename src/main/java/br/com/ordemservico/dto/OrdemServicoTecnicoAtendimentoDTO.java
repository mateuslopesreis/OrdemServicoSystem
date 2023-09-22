package br.com.ordemservico.dto;

import java.io.Serializable;
import java.util.List;

public class OrdemServicoTecnicoAtendimentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String atendimentos;
	private Long id;
	private Integer status;
	
	
	OrdemServicoTecnicoAtendimentoDTO(){}


	public OrdemServicoTecnicoAtendimentoDTO(String atendimentos, Long id, Integer status) {
		this.atendimentos = atendimentos;
		this.id = id;
		this.status = status;
	}


	public String getAtendimentos() {
		return atendimentos;
	}


	public void setAtendimentos(String atendimentos) {
		this.atendimentos = atendimentos;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}

}
