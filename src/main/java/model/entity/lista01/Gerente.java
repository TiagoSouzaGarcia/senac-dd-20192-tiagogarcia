package model.entity.lista01;

public class Gerente extends Empregado {
	
	private double comissao;

	public Gerente(int id, String nome, String cpf, char sexo, int idade, double salarioBruto, Lotacao lotacao, double comissao) {
		super(id, nome, cpf, sexo, idade, salarioBruto, lotacao);
		this.comissao = comissao;
	}
	
	public double calcularSalario() {
		return this.getSalarioBase() * 0.9 + this.comissao;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	
	

}
