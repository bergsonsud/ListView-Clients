package Enum;

public enum Status {
	
	NOVO(1,"Novo"),FINALIZADO(4,"Finalizado")	;
	
	int cod;
	String descricao;
	
	Status(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	
	

}
