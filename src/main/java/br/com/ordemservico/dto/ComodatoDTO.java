package br.com.ordemservico.dto;

import java.io.Serializable;

import br.com.ordemservico.entities.Comodato;
import br.com.ordemservico.entities.OrdemServico;

public class ComodatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String dataInstalacao;
	private OrdemServico os;
	
	 public ComodatoDTO() {
		// TODO Auto-generated constructor stub
	}
	 
	 public ComodatoDTO(Long id, String dataInstalacao, OrdemServico os) {
			this.id = id;
			this.dataInstalacao = dataInstalacao;
			this.os = os;
		}


	public ComodatoDTO(Comodato entity) {
		this.id = entity.getId();
		this.dataInstalacao = entity.getDataInstalacao();
		this.os = entity.getOs();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDataInstalacao() {
		return dataInstalacao;
	}


	public void setDataInstalacao(String dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}

	public OrdemServico getOs() {
		return os;
	}

	public void setOs(OrdemServico os) {
		this.os = os;
	}
	
	
}
