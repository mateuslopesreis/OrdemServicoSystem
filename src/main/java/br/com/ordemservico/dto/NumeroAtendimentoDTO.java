package br.com.ordemservico.dto;

import java.io.Serializable;

public class NumeroAtendimentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer funcionario;
	private String nome;
	
	
	public NumeroAtendimentoDTO() {
		// TODO Auto-generated constructor stub
	}


	public NumeroAtendimentoDTO(Integer funcionario, String nome) {
		super();
		this.funcionario = funcionario;
		this.nome = nome;
	}


	public Integer getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Integer funcionario) {
		this.funcionario = funcionario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
