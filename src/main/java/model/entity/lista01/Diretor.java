package model.entity.lista01;

public class Diretor extends Empregado {
	
	private double comissao;

	public Diretor(int id, String nome, String cpf, char sexo, int idade, double salarioBruto, Lotacao lotacao, double comissao) {
		super(id, nome, cpf, sexo, idade, salarioBruto, lotacao);
		this.comissao = comissao;
	}
	
	public double calcularSalario() {
		return this.getSalarioBase() * 3 + this.comissao;
	}
	
	public double getComissao() {
		return comissao;
	}
	
	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

}
