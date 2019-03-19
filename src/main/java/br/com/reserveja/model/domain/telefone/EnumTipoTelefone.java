package br.com.reserveja.model.domain.telefone;

public enum EnumTipoTelefone {

	COMERCIAL("C"), RESIDENCIAL("R"), MOVEL("M");
	
	private String value;
	
	
	private EnumTipoTelefone(String value) {
		this.value = value;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	
	
}
