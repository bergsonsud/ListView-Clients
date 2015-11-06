package entidades;

public class Chamado {
	
	private String descricao;
	private String cliente;
	private String status;
	private String urgencia;
	
	
	public Chamado(String descricao,String cliente,String status,String urgencia){
		
		
		this.setDescricao(descricao);
		this.setCliente(cliente);		
		this.setStatus(status);
		this.setUrgencia(urgencia);
	
	}

	
	


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}



	public String getUrgencia() {
		return urgencia;
	}



	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}



	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}



	






}
