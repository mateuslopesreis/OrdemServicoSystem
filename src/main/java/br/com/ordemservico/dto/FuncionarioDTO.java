package br.com.ordemservico.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.ordemservico.entities.Funcionario;
import br.com.ordemservico.enums.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FuncionarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@Size(min = 5, max=100, message ="Deve ter entre 5 e 100 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	@Email(message="Entrar com um email válido")
	private String email;
	private String telefone;
	private Integer perfil;
	private String login;
	
	
	private Set<RoleDTO> roles = new HashSet<>();

	
	public FuncionarioDTO() {}
	
	public FuncionarioDTO(Funcionario entity) { 
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.telefone = entity.getTelefone();
		this.perfil = entity.getPerfil().getCod();
		this.login = entity.getLogin();
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
		
		
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

	public Set<RoleDTO> getRoles() {
		return roles;
	}	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	
	
	

}
