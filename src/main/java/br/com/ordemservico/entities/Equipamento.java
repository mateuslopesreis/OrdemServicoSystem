package br.com.ordemservico.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ordemservico.enums.Dispositivo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_equipamento")
public class Equipamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	private Integer dispositivo;
	private String marca;
	private String foto;
	private Integer quantidade;
	
	@OneToMany(mappedBy = "equipamento", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EquipamentoItem> equipamentosItem;
	
	
	public Equipamento() {
		// TODO Auto-generated constructor stub
	}

	public Equipamento(Long id, String nome, String descricao, Dispositivo dispositivo, String marca,
			String foto, Integer quantidade, List<EquipamentoItem> equipamentosItem) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		this.dispositivo = (dispositivo == null) ? 0 : dispositivo.getCod();
		this.foto = foto;
		this.quantidade = quantidade;
		this.equipamentosItem = equipamentosItem;
	}

	
	public List<EquipamentoItem> getEquipamentosItem() {
		return equipamentosItem;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public Dispositivo getDispositivo() {
		return Dispositivo.toEnum(this.dispositivo);
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo.getCod();
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}


	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
		Equipamento other = (Equipamento) obj;
		return Objects.equals(id, other.id);
	}


}