package model.entity.lista01;

public class Lotacao {
	private int id;
	private String nome;
	private Lotacao lotacaoSuperior;
	private Empregado responsavel;
	
	
	
	public Lotacao(int id, String nome, Lotacao lotacaoSuperior, Empregado responsavel) {
		super();
		this.id = id;
		this.nome = nome;
		this.lotacaoSuperior = lotacaoSuperior;
		this.responsavel = responsavel;
	}



	public Lotacao() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Lotacao getLotacaoSuperior() {
		return lotacaoSuperior;
	}



	public void setLotacaoSuperior(Lotacao lotacaoSuperior) {
		this.lotacaoSuperior = lotacaoSuperior;
	}



	public Empregado getResponsavel() {
		return responsavel;
	}



	public void setResponsavel(Empregado responsavel) {
		this.responsavel = responsavel;
	}
	
	
	
	

}
