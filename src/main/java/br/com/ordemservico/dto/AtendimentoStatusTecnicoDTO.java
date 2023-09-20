package br.com.ordemservico.dto;

import java.io.Serializable;

public class AtendimentoStatusTecnicoDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String nome;
	
	public AtendimentoStatusTecnicoDTO() {}

	public AtendimentoStatusTecnicoDTO(String titulo, String nome) {
		this.titulo = titulo;
		this.nome = nome;
	}
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
