package br.com.ordemservico.dto;

public class FuncionarioInsertDTO extends FuncionarioDTO {
	private static final long serialVersionUID = 1L;

	private String senha;

	public FuncionarioInsertDTO() {
		super();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
}
