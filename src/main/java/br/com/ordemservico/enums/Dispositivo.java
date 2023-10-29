package br.com.ordemservico.enums;

public enum Dispositivo {


	ROTEADOR(0, "ROTEADOR"), MODEM(1, "MODEM");

	private Integer cod;
	private String descricao;
	
	private Dispositivo(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Dispositivo toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		for(Dispositivo x : Dispositivo.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Dispositivo inválido"+cod);
	}

}

