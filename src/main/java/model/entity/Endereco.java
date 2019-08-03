package model.entity;

public class Endereco {
	
	private String rua;
	private String cep;
	private String estado;
	private String cidade;
	private String numero;
	private String bairro;
	
	
	public Endereco(String rua, String cep, String estado, String cidade, String numero, String bairro) {
		super();
		this.rua = rua;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.numero = numero;
		this.bairro = bairro;
	}
	
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	@Override
	public String toString() {
		return "Endereço [rua=" + rua + ", cep=" + cep + ", estado=" + estado + ", cidade=" + cidade + ", numero="
				+ numero + ", bairro=" + bairro + "]";
	}
	
	
	

}
