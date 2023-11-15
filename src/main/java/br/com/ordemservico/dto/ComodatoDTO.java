package br.com.ordemservico.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.ordemservico.entities.Comodato;
import br.com.ordemservico.entities.EquipamentoItem;
import br.com.ordemservico.entities.OrdemServico;

public class ComodatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String dataInstalacao;
	private String dataDevolucao;
	private OrdemServico os;
	private EquipamentoItem equipamentoItem;
	
	 public ComodatoDTO() {
		// TODO Auto-generated constructor stub
	}
	 
	 public ComodatoDTO(Long id, String dataInstalacao, String dataDevolucao, OrdemServico os,
			 EquipamentoItem equipamentoItem) {
			this.id = id;
			this.dataInstalacao = dataInstalacao;
			this.dataDevolucao = dataDevolucao;
			this.os = os;
			this.equipamentoItem = equipamentoItem;
		}


	public ComodatoDTO(Comodato entity) {
		this.id = entity.getId();
		this.dataInstalacao = entity.getDataInstalacao();
		this.dataDevolucao = entity.getDataDevolucao();
		this.os = entity.getOs();
		this.equipamentoItem = entity.getEquipamentoItem();
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

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public EquipamentoItem getEquipamentoItem() {
		return equipamentoItem;
	}

	public void setEquipamentoItem(EquipamentoItem equipamentoItem) {
		this.equipamentoItem = equipamentoItem;
	}
	
	
}
