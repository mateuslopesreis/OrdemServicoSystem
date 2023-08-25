package br.com.ordemservico.enums;

public enum TipoServico {
	
	INTERNET_NAO_FUNCIONA(0, "INTERNET_NAO_FUNCIONA"), INTERNET_LENTA(1, "INTERNET_LENTA"), CONFIGURACAO_DE_EQUIPAMENTO(2,"CONFIGURACAO_DE_EQUIPAMENTO"), INSTALACAO(3,"INSTALACAO");

	private Integer cod;
	private String descricao;
	
	private TipoServico(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoServico toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		for(TipoServico x : TipoServico.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Tipo de serviço inválido"+cod);
	}
	
}
