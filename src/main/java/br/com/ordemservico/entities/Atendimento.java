package br.com.ordemservico.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_atendimento")
public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String relatoTecnico;
	
	@ManyToOne
	@JoinColumn(name ="id_funcionario_fk")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "id_os_fk")
	private OrdemServico os;
	
	public Atendimento() {}

	public Atendimento(Long id, String relatoTecnico, Funcionario funcionario, OrdemServico os) {
		super();
		this.id = id;
		this.relatoTecnico = relatoTecnico;
		this.funcionario = funcionario;
		this.os = os;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRelatoTecnico() {
		return relatoTecnico;
	}

	public void setRelatoTecnico(String relatoTecnico) {
		this.relatoTecnico = relatoTecnico;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public OrdemServico getOs() {
		return os;
	}

	public void setOs(OrdemServico os) {
		this.os = os;
	}

}
