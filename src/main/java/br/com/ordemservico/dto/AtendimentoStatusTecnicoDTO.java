package br.com.ordemservico.dto;

import java.io.Serializable;

import br.com.ordemservico.entities.Cliente;

public class AtendimentoStatusTecnicoDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private Integer prioridade;
	private String cliente;
	private String nome;
	private String descricao;
	
	
	public AtendimentoStatusTecnicoDTO() {}

	public AtendimentoStatusTecnicoDTO(Long id, String titulo, Integer prioridade, String cliente, String nome, String descricao) {
		this.id = id;
		this.titulo = titulo;
		this.cliente = cliente;
		this.nome = nome;
		this.prioridade = prioridade;
		this.descricao = descricao;
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

	
	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
