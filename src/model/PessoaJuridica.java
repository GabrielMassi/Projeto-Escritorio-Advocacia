package model;

public class PessoaJuridica extends Pessoa{
	
	private final String cnpj;
	
	//----------------------
	
	public PessoaJuridica(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}
	
	public String getCadastroRF() {
		return this.cnpj;
	}
	
}
