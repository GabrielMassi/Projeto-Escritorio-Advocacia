package model;

import java.util.Date;

public class Audiencia {

	private Processo processo;
	
	private final Date data = new Date();
	
	private Advogado advogado;
	
	private String recomendacoes;

	
//------------------------
	
	public Audiencia(Processo processo, Advogado advogado, String recomendacoes) {
		super();
		this.processo = processo;
		this.advogado = advogado;
		this.recomendacoes = recomendacoes;
	}


	public Advogado getAdvogado() {
		return advogado;
	}


	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}


	public String getRecomendacoes() {
		return recomendacoes;
	}


	public void setRecomendacoes(String recomendacoes) {
		this.recomendacoes = recomendacoes;
	}


	public Processo getProcesso() {
		return processo;
	}


	public Date getData() {
		return data;
	}
	
	
	
}
