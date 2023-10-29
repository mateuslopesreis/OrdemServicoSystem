package br.com.ordemservico.dto;

import java.io.Serializable;

import br.com.ordemservico.entities.Equipamento;
import br.com.ordemservico.entities.EquipamentoItem;
import br.com.ordemservico.enums.Situacao;

public class EquipamentoItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer serial;
	private Integer situacao;
	private Equipamento equipamento;
	
	
	public EquipamentoItemDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public EquipamentoItemDTO(Long id, Integer serial, Situacao situação, Equipamento equipamento) {
		this.id = id;
		this.serial = serial;
		this.situacao = situação.getCod();
		this.equipamento = equipamento;
	}
	
	public EquipamentoItemDTO(EquipamentoItem entity) { 
		this.id = entity.getId();
		this.serial = entity.getSerial();
		this.situacao = entity.getSituacao().getCod();	
		this.equipamento = entity.getEquipamento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public Situacao getSituacao() {
		return Situacao.toEnum(this.situacao);
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao.getCod();
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	
	

}
