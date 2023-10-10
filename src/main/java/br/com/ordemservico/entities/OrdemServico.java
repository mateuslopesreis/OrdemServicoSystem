package br.com.ordemservico.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ordemservico.enums.Prioridade;
import br.com.ordemservico.enums.Status;
import br.com.ordemservico.enums.TipoServico;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_ordem_servico")
public class OrdemServico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertura;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFechamento;
	
	private Integer tipoServico;
	private Integer prioridade;
	private Integer status;
	
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	
	@OneToMany(mappedBy = "os", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Atendimento> atendimentos;
	
	public OrdemServico() {
		this.setDataAbertura(LocalDateTime.now());
		//this.setPrioridade(Prioridade.BAIXA);
		//this.setStatus(Status.ABERTO);
	}

	public OrdemServico(Long id, String titulo, 
			TipoServico tipoServico, Prioridade prioridade, Status status, Cliente cliente, List<Atendimento> atendimentos) {
		this.id = id;
		this.titulo = titulo;
		this.setDataAbertura(LocalDateTime.now());
		this.tipoServico = (tipoServico == null) ? 0 : tipoServico.getCod();
		this.prioridade = (prioridade == null) ? 0 : prioridade.getCod();
		this.status = (status == null) ? 0 : status.getCod();
		this.cliente = cliente;
		this.atendimentos = atendimentos;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		return Objects.equals(id, other.id);
	}

}
