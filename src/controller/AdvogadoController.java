package controller;

import java.io.Serializable;
import java.util.Map;
//import java.util.Set;
import java.util.TreeMap;

import model.*;

public class AdvogadoController implements Serializable {

	private static final long serialVersionUID = 1945660900431033557L;

	private Map<String, Advogado> advogados;

	public AdvogadoController() {
		advogados = new TreeMap<>();
	}
	
	public Advogado getAdvogado(String oab) {
		Advogado c = this.advogados.get(oab);
		if(c != null){
			return this.advogados.get(oab);
		}else {
			throw new RuntimeException("Advogado não cadastrado. Deseja realizar este cadastro?");
		}
	}
	
	public void addAdvogado(String cadastro, String oab, String curriculo) {
		Pessoa p = MainController.getPessoaController().getPessoa(cadastro);
		Advogado a = new Advogado(p, oab, curriculo);
		this.advogados.put(a.getPessoa().getCadastroRF(), a);
	}
	
}