package br.com.ordemservico.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ordemservico.entities.Atendimento;
import br.com.ordemservico.entities.Cliente;
import br.com.ordemservico.entities.OrdemServico;
import br.com.ordemservico.enums.Prioridade;
import br.com.ordemservico.enums.Status;
import br.com.ordemservico.enums.TipoServico;

public class OrdemServicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;
	
	private LocalDateTime dataAbertura;
	
	private LocalDateTime dataFechamento;
	
	private Integer tipoServico;
	private Integer prioridade;
	private Integer status;
	private Cliente cliente;
	
	private List<Atendimento> atendimentos = new ArrayList<>(); 
	
	public OrdemServicoDTO() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public OrdemServicoDTO(Long id, String titulo, LocalDateTime dataAbertura, LocalDateTime dataFechamento,
			Integer tipoServico, Integer prioridade, Integer status, Cliente cliente) {
		this.id = id;
		this.titulo = titulo;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
		this.tipoServico = tipoServico;
		this.prioridade = prioridade;
		this.status = status;
		this.cliente = cliente;
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
		this.cliente = entity.getCliente();

	}
	
	public OrdemServicoDTO(OrdemServico entity, List<Atendimento> atendimentos) {
		this(entity);
		this.atendimentos = atendimentos.stream().map(x -> new Atendimento(
				x.getId(), x.getRelatoTecnico(), x.getFuncionario(), null))
				.collect(Collectors.toList());
	}
	
	
	

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
