package br.com.ordemservico.dto;

import java.io.Serializable;
import java.util.List;

public class OrdemServicoTecnicoSemAtendimentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String atendimentos;
	private Integer status;
	
	
	OrdemServicoTecnicoSemAtendimentoDTO(){}


	public OrdemServicoTecnicoSemAtendimentoDTO(String atendimentos, Integer status) {
		this.atendimentos = atendimentos;
		this.status = status;
	}


	public String getAtendimentos() {
		return atendimentos;
	}


	public void setAtendimentos(String atendimentos) {
		this.atendimentos = atendimentos;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}

}
