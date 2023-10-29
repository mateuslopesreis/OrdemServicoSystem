package br.com.ordemservico.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="tb_comodato")
public class Comodato implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dataInstalacao;
	
	@ManyToOne
	@JoinColumn(name = "id_os_fk")
	private OrdemServico os;
	
	public Comodato() {
		// TODO Auto-generated constructor stub
	}

	public Comodato(Long id, String dataInstalacao) {
		this.id = id;
		this.dataInstalacao = dataInstalacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataInstalacao() {
		return dataInstalacao;
	}

	public void setDataInstalacao(String dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}
	
	
	public OrdemServico getOs() {
		return os;
	}

	public void setOs(OrdemServico os) {
		this.os = os;
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
		Comodato other = (Comodato) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}	
