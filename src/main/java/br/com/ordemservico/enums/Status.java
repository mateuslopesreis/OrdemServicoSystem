package br.com.ordemservico.enums;

public enum Status {
	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), FECHADO(2,"FECHADO");

	private Integer cod;
	private String descricao;
	
	private Status(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Status toEnum(Integer status) {
		if(status==null) {
			return null;
		}
		for(Status x : Status.values()) {
			if(status.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Status inválido"+status);
	}
}
