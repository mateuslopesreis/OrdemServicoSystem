package br.com.ordemservico.dto;

import java.io.Serializable;

import br.com.ordemservico.entities.Atendimento;
import br.com.ordemservico.entities.Funcionario;
import br.com.ordemservico.entities.OrdemServico;

public class AtendimentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String relatoTecnico;
	private Funcionario funcionario;
	private OrdemServico os;
	
	public AtendimentoDTO() {
	}

	public AtendimentoDTO(Long id, String relatoTecnico, Funcionario funcionario, OrdemServico os) {
		
		this.id = id;
		this.relatoTecnico = relatoTecnico;
		this.funcionario = funcionario;
		this.os = os;
	}
	
	public AtendimentoDTO(Atendimento entity) {
		
		this.id = entity.getId();
		this.relatoTecnico = entity.getRelatoTecnico();
		this.funcionario = entity.getFuncionario();
		this.os = entity.getOs();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRelatoTecnico() {
		return relatoTecnico;
	}

	public void setRelatoTecnico(String relatoTecnico) {
		this.relatoTecnico = relatoTecnico;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public OrdemServico getOs() {
		return os;
	}

	public void setOs(OrdemServico os) {
		this.os = os;
	}
	
	
}
