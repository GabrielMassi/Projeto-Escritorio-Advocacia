package controller;

import java.io.Serializable;
import java.util.Map;
//import java.util.Set;
import java.util.TreeMap;

import model.*;
import util.Validacoes;

public class AdvogadoController implements Serializable {

	private static final long serialVersionUID = 1945660900431033557L;

	private Map<String, Advogado> advogados;

	public AdvogadoController() {
		advogados = new TreeMap<>();
	}
	
	public Advogado getAdvogado(String oab) {
		Advogado c = this.advogados.get(oab);
		if(c != null && advogados.containsKey(oab) && Validacoes.isOab(oab)){
			return this.advogados.get(oab);
		}else {
			throw new RuntimeException("Advogado não cadastrado. Deseja realizar este cadastro?");
		}
	}
	
	public Map<String, Advogado> getAdvogados(){
		return this.advogados;
	}
	
	public void addAdvogado(String cadastro, String oab, String curriculo) {
		Pessoa p = MainController.getPessoaController().getPessoa(cadastro);
		Advogado a = new Advogado(p, oab, curriculo);
		this.advogados.put(a.getOab(), a);
	}
	
	public StringBuilder listar() {
		
		StringBuilder sb = new StringBuilder();
		
		for (Map.Entry<String, Advogado> c: advogados.entrySet()) {
			
			sb.append("Nome: " + c.getValue().getPessoa().getNome());
			sb.append("\nOAB: " + c.getValue().getOab());
			sb.append("\nEmail: " + c.getValue().getPessoa().getEmail());
			sb.append("\nTelefone: " + c.getValue().getPessoa().getTelefone());
			sb.append("\nProcessos abertos: " + c.getValue().processosAbertos() + "\n\n");
						
		}
		
		return sb;
		
	}
	
}