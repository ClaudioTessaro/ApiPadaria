package br.com.padaria.domain.enums;

public enum TipoPagamento {
	AVISTA(1, "A vista"),
	CARTAO(2, "Cartão");
	
	private int cod;
	private String descricao;
	
	private TipoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoPagamento x: TipoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
						
		}
		throw new IllegalArgumentException("Id invalido: "+cod);
		
	}

}
