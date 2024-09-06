package model;

public class PessoaFisica extends Pessoa {

	private final String cpf;
	
//----------------------
	
	public PessoaFisica(String nome, String email, long telefone, String cpf) {
		super(nome, email, telefone);
		this.cpf = cpf;
	}
	
	public String getCadastroRF() {
		return this.cpf;
	}
	
}
