package br.com.ordemservico.entities;

import java.io.Serializable;
import java.util.Objects;

import br.com.ordemservico.enums.Situacao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_equipamento_item")
public class EquipamentoItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer serial;
	private Integer situacao;
	
	@ManyToOne
	@JoinColumn(name = "id_equipamento_fk")
	private Equipamento equipamento;
	
	
	public EquipamentoItem() {
		// TODO Auto-generated constructor stub
	}

	public EquipamentoItem(Long id, Integer serial, Situacao situacao) {
		super();
		this.id = id;
		this.serial = serial;
		this.situacao = (situacao == null) ? 0 : situacao.getCod();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public Situacao getSituacao() {
		return Situacao.toEnum(this.situacao);
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao.getCod();
	}
	
	

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
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
		EquipamentoItem other = (EquipamentoItem) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
