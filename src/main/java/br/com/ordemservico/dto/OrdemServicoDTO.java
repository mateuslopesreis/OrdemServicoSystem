package br.com.ordemservico.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ordemservico.entities.Cliente;
import br.com.ordemservico.entities.OrdemServico;
import br.com.ordemservico.enums.Prioridade;
import br.com.ordemservico.enums.Status;
import br.com.ordemservico.enums.TipoServico;

public class OrdemServicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertura;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFechamento;
	
	private Integer tipoServico;
	private Integer prioridade;
	private Integer status;
	private Long cliente;
	
	public OrdemServicoDTO() {
		// TODO Auto-generated constructor stub
	}

	
	
	public OrdemServicoDTO(OrdemServico entity) {
		super();
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.dataAbertura = entity.getDataAbertura();
		this.dataFechamento = entity.getDataFechamento();
		this.tipoServico = entity.getTipoServico().getCod();
		this.prioridade = entity.getPrioridade().getCod();
		this.status = entity.getStatus().getCod();
		this.cliente = entity.getCliente().getId();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public TipoServico getTipoServico() {
		return TipoServico.toEnum(this.tipoServico);
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico.getCod();
	}
	
	public Prioridade getPrioridade() {
		return Prioridade.toEnum(this.prioridade);
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade.getCod();
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	
	
	
}
