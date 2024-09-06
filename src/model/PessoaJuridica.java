package model;

public class PessoaJuridica extends Pessoa{
	
	private final String cnpj;
	
	//----------------------
	
	public PessoaJuridica(String nome, String email, long telefone, String cnpj) {
		super(nome, email, telefone);
		this.cnpj = cnpj;
	}
		
	public String getCadastroRF() {
		return this.cnpj;
	}
	
}
