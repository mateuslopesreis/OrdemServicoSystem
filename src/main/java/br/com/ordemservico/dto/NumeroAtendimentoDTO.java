package br.com.ordemservico.dto;

import java.io.Serializable;

public class NumeroAtendimentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	
	public NumeroAtendimentoDTO() {
		// TODO Auto-generated constructor stub
	}


	public NumeroAtendimentoDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
