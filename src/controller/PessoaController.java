package controller;

import java.io.Serializable;
import java.util.Map;
//import java.util.Set;
import java.util.TreeMap;

import model.*;
import util.*;

public class PessoaController implements Serializable {

	private static final long serialVersionUID = 1945660900431033557L;

	private Map<String, Pessoa> pessoas;

	public PessoaController() {
		pessoas = new TreeMap<>();
	}
	
	public Pessoa getPessoa(String cadastro) {
		Pessoa p = this.pessoas.get(cadastro);
		if(p != null){
			return this.pessoas.get(cadastro);
		}else {
			throw new RuntimeException("Cadastro não encontrado. Deseja realizar este cadastro?");
		}
	}
	
	public Map<String, Pessoa> getPessoas(){
		return this.pessoas;
	}
	
	public void addPessoaFisica(String nome, String cadastro) {
		if(ValidaCPF.isCPF(cadastro)){
			Pessoa p = new PessoaFisica(nome, cadastro);
			pessoas.put(p.getCadastroRF(), p);
		}else
			throw new RuntimeException("CPF Inválido");
	}
	
	public void addPessoaJuridica(String nome, String cadastro) {
		if(ValidaCPF.isCPF(cadastro)){
			Pessoa p = new PessoaJuridica(nome, cadastro);
			pessoas.put(p.getCadastroRF(), p);
		}else {
			throw new RuntimeException("CNPJ Inválido");
		}
	}
	
}