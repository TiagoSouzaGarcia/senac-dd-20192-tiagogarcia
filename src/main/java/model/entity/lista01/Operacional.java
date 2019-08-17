package model.entity.lista01;

public class Operacional extends Empregado {

	

	public Operacional(int id, String nome, String cpf, char sexo, int idade, double salarioBruto, Lotacao lotacao) {
		super(id, nome, cpf, sexo, idade, salarioBruto, lotacao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularSalario() {
		return this.getSalarioBase() * 0.85;
	}

}
