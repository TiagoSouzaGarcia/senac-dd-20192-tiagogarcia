package model.entity;

public class Telefone {
	
	private String codigoPais;
	private String ddd;
	private String numero;
	private String tipo;
	private boolean ativo;
	
	public Telefone(String codigoPais, String ddd, String numero, String tipo, boolean ativo) {
		super();
		this.codigoPais = codigoPais;
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	@Override
	public String toString() {
		return "Telefone [codigoPais=" + codigoPais + ", ddd=" + ddd + ", numero=" + numero + ", tipo=" + tipo
				+ ", ativo=" + ativo + "]";
	}
	
	

}
