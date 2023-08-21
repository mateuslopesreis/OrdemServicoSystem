package br.com.ordemservico.dto;

import java.io.Serializable;

import br.com.ordemservico.entities.Funcionario;
import br.com.ordemservico.enums.Perfil;

public class FuncionarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private Integer perfil;
	private String login;
	private String senha;
	
	public FuncionarioDTO() {}
	
	public FuncionarioDTO(Funcionario entity) { 
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.telefone = entity.getTelefone();
		this.perfil = entity.getPerfil().getCod();
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Perfil getPerfil() {
		return Perfil.toEnum(this.perfil);
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil.getCod();
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
