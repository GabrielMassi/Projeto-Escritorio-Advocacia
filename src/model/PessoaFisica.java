package model;

public class PessoaFisica extends Pessoa {

	private final String cpf;
	
//----------------------
	
	public PessoaFisica(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
	}
	
	public String getCadastroRF() {
		return this.cpf;
	}
	
}
