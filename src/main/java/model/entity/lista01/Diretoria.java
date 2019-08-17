package model.entity.lista01;

import java.util.ArrayList;

public class Diretoria extends Lotacao{
	private String sigla;
	private ArrayList<Gerencia> gerencias;
	
	public Diretoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Diretoria(int id, String nome, Lotacao lotacaoSuperior, Empregado responsavel) {
		super(id, nome, lotacaoSuperior, responsavel);
		// TODO Auto-generated constructor stub
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public ArrayList<Gerencia> getGerencias() {
		return gerencias;
	}
	public void setGerencias(ArrayList<Gerencia> gerencias) {
		this.gerencias = gerencias;
	}
	
	

}
