package br.com.ordemservico.enums;

public enum Situacao {
	ALOCADO(0, "ALOCADO"), DISPONIVEL(1, "DISPONIVEL");

	private Integer cod;
	private String descricao;
	
	private Situacao(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Situacao toEnum(Integer situcao) {
		if(situcao==null) {
			return null;
		}
		for(Situacao x : Situacao.values()) {
			if(situcao.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Status inválido"+situcao);
	}
}
