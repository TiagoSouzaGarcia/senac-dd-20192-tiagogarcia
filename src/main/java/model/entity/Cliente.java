package model.entity;

import java.util.ArrayList;

public class Cliente {
	
	private int id;
	private String nome;
	private String cpf;
	private ArrayList<Telefone> telefones;
	private String sobrenome;
	private Endereco endereco;
	
	public Cliente(int id, String nome, String cpf, ArrayList<Telefone> telefones, String sobrenome, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefones = telefones;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
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
	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(ArrayList<Telefone> telefones) {
		this.telefones = telefones;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
		
	public String getNomeCompleto() {
		
		String nomeCompleto = this.nome + " " + this.sobrenome;
		return nomeCompleto;
		
	}

	@Override
	public String toString() {
		String mensagem = "Cliente: " + this.getNomeCompleto() + " (" + cpf + "). " + "\nEndereço: " + endereco
				+ "\nTelefones: ";

		for (Telefone t : telefones) {
			mensagem += t.toString() + "\n";
		}

		return mensagem;
	}

}
