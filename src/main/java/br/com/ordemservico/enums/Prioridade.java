package br.com.ordemservico.enums;

public enum Prioridade {
	
	ALTA(0, "ALTA"), MEDIA(1, "MEDIA"), BAIXA(2,"BAIXA");

	private Integer cod;
	private String descricao;
	
	private Prioridade(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Prioridade toEnum(Integer prioridade) {
		if(prioridade==null) {
			return null;
		}
		for(Prioridade x : Prioridade.values()) {
			if(prioridade.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Prioridade inválida"+prioridade);
	}
}
