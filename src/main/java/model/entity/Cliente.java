package model.entity;

import java.util.List;

public class Cliente {
	
	private String nome;
	private String cpf;
	private List<Telefone> telefones;
	private String sobrenome;
	private Endereco endereco;
	
	public Cliente(String nome, String cpf, List<Telefone> telefones, String sobrenome, Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefones = telefones;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Endereco getEndereço() {
		return endereco;
	}
	public void setEndereço(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getNomeCompleto() {
		
		String nomeCompleto = this.nome + " " + this.sobrenome;
		return nomeCompleto;
		
	}

	@Override
	public String toString() {
		String mensagem = "Cliente: " + this.getNomeCompleto() + " (" + cpf + "). "
				+ "\nEndereço: " + endereco
				+ "\nTelefone"
				
				
	}

}
