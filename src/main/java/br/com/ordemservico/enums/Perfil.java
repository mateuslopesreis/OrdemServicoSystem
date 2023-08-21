package br.com.ordemservico.enums;

public enum Perfil {
	SUPERVISOR(0, "SUPERVISOR"), SUPORTE(1, "SUPORTE"), TECNICO(2,"TECNICO");

	private Integer cod;
	private String descricao;
	
	private Perfil(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Perfil inválido"+cod);
	}

}

