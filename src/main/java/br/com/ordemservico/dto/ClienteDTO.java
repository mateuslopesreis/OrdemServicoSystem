package br.com.ordemservico.dto;

import java.io.Serializable;

import br.com.ordemservico.entities.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String nome;
	private String email;
	private String rua;
	private String bairro;
	private String numero;
	private String login;
	private String senha;
	
	public ClienteDTO() {}

	public ClienteDTO(Cliente entity) { 
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.rua = entity.getRua();
		this.bairro = entity.getBairro();
		this.numero = entity.getNumero();
		this.login = entity.getLogin();
		this.senha = entity.getSenha();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
