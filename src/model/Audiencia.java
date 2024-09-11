package model;

import java.util.Date;

public class Audiencia {

	private Processo processo;
	
	private final Date data = new Date();
	
	private String recomendacoes;

	
//------------------------
	
	public Audiencia(Processo processo, String recomendacoes) {
		super();
		this.processo = processo;
		this.recomendacoes = recomendacoes;
	}

	public String getRecomendacoes() {
		return recomendacoes;
	}

	public Processo getProcesso() {
		return processo;
	}


	public Date getData() {
		return data;
	}
	
	
}
