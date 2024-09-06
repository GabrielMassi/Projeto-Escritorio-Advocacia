package model;

public class Tribunal {

	private String sigla;
	

	private String nome;
	
	private String secao;
	
//---------------------
	
	public Tribunal(String sigla, String nome, String secao) {
		super();
		this.sigla = sigla;
		this.nome = nome;
		this.secao = secao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}
	
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
