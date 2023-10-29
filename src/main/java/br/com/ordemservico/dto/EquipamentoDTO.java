package br.com.ordemservico.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ordemservico.entities.Equipamento;
import br.com.ordemservico.entities.EquipamentoItem;
import br.com.ordemservico.enums.Dispositivo;

public class EquipamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String descricao;
	private Integer dispositivo;
	private String marca;
	private String foto;
	private Integer quantidade;
	
	private List<EquipamentoItem> equipamentosItem = new ArrayList<>();
	
	
	public EquipamentoDTO() {
		// TODO Auto-generated constructor stub
	}


	
	public EquipamentoDTO(Equipamento entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.descricao = entity.getDescricao();
		this.dispositivo = entity.getDispositivo().getCod();
		this.marca = entity.getMarca();
		this.foto = entity.getFoto();
		this.quantidade = entity.getQuantidade();
	}
	
	public EquipamentoDTO(Equipamento entity, List<EquipamentoItem> equipamentosItem) {
		this(entity);
		this.equipamentosItem = equipamentosItem.stream().map(x -> new EquipamentoItem(
				x.getId(), x.getSerial(), x.getSituacao()))
				.collect(Collectors.toList());
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
	
}
