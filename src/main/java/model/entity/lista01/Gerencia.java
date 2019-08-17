package model.entity.lista01;

import java.util.ArrayList;

public class Gerencia extends Lotacao{
	private ArrayList<Operacional> operacionais;

	public Gerencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gerencia(int id, String nome, Lotacao lotacaoSuperior, Empregado responsavel) {
		super(id, nome, lotacaoSuperior, responsavel);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Operacional> getOperacionais() {
		return operacionais;
	}

	public void setOperacionais(ArrayList<Operacional> operacionais) {
		this.operacionais = operacionais;
	}
	
	

}
