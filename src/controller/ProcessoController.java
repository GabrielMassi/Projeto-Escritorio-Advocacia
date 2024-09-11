package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
//import java.util.Set;
import java.util.TreeMap;

import model.*;

public class ProcessoController implements Serializable {

	private static final long serialVersionUID = 1945660900431033557L;

	private Map<Long, Processo> processos;

	public ProcessoController() {
		processos = new TreeMap<>();
	}

	public Processo getProcesso(long numero) {
		Processo p = this.processos.get(numero);
		if(p!=null)
			return p;
		else
			throw new RuntimeException("Processo não encontrado");
	}
	
	public Set<Long> getProcessos(){
		return processos.keySet();
	}
	
	public void addProcesso(String cadRF_cliente, String cadRF_prt_contraria, String sigla, String oab) {
		Cliente cli = MainController.getClienteController().getCliente(cadRF_cliente);
		Pessoa contr = MainController.getPessoaController().getPessoa(cadRF_prt_contraria);
		Tribunal trib = MainController.getTribunalController().getTribunal(sigla);
		Advogado adv = MainController.getAdvogadoController().getAdvogado(oab);
		Processo p = new Processo(cli, contr, trib, adv);
		this.processos.put(p.getNumero(), p);
	}
	
	public StringBuilder listar() {
		
		StringBuilder sb = new StringBuilder();
		
		for (Map.Entry<Long, Processo> p : processos.entrySet()) {
			
			sb.append(p.toString());
			
		}
		
		return sb;
		
	}

}

