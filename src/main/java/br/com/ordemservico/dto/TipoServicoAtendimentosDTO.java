package br.com.ordemservico.dto;

import java.io.Serializable;

public class TipoServicoAtendimentosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer tipo_servico;

	public TipoServicoAtendimentosDTO(Integer tipo_servico) {
		super();
		this.tipo_servico = tipo_servico;
	}

	public Integer getTipo_servico() {
		return tipo_servico;
	}

	public void setTipo_servico(Integer tipo_servico) {
		this.tipo_servico = tipo_servico;
	}
	
	
	
}
