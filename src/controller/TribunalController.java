package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
//import java.util.Set;
import java.util.TreeMap;

import model.*;

public class TribunalController implements Serializable {

	private static final long serialVersionUID = 1945660900431033557L;

	private Map<String, Tribunal> tribunais;

	public TribunalController() {
		tribunais = new TreeMap<>();
	}

	public Tribunal getTribunal(String sigla) {
		Tribunal t = this.tribunais.get(sigla);
		if(t!=null)
			return t;
		else
			throw new RuntimeException("Tribunal não registrado");
	}
	
	public Set<String> getTribunais(){
		return tribunais.keySet();
	}
	
	public void addTribunal(String sigla, String nome, String secao) {
		Tribunal t = new Tribunal(sigla, nome, secao);
		this.tribunais.put(t.getSigla(), t);
	}

public StringBuilder listar() {
		
		StringBuilder sb = new StringBuilder();
		
		for (Map.Entry<String, Tribunal> t: tribunais.entrySet()) {
			
			sb.append("Sigla: " + t.getValue().getSigla());
			sb.append("\nNome: " + t.getValue().getNome());
			sb.append("\nSeção: " + t.getValue().getSecao() + "\n\n");
						
		}
		
		return sb;
		
	}
	
}

