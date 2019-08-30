package model.entity;

public class Telefone {
	
	private int id;
	private String codigoPais;
	private String ddd;
	private String numero;
	private String tipoLinha;
	private boolean ativo;
	private Cliente cliente;
	
	
	public Telefone() {
		
	}
	
		
	public Telefone(int id, Cliente cliente, String codigoPais, String ddd, String numero, String tipoLinha,
			boolean ativo) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.codigoPais = codigoPais;
		this.ddd = ddd;
		this.numero = numero;
		this.tipoLinha = tipoLinha;
		this.ativo = ativo;
	}
	
	


	public String getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipoLinha() {
		return tipoLinha;
	}
	public void setTipoLinha(String tipoLinha) {
		this.tipoLinha = tipoLinha;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return " id=" + id + " |idCliente: " + cliente.getId() + "| codigoPais=" + codigoPais + "(" + ddd + ")"
				+ numero + " - Linha: " + tipoLinha + ( ativo ? "Ativa" : "Inativa");
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	

}
