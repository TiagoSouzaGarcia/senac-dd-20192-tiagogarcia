package model.entity;

import java.util.ArrayList;

public class Cliente {
	
	private int id;
	private String nome;
	private String cpf;
	private ArrayList<Telefone> telefones;
	private String sobrenome;
	private Endereco endereco;
	
	public Cliente( String nome, String sobrenome, String cpf, ArrayList<Telefone> telefones,  Endereco endereco) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.telefones = telefones;
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
