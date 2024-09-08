package controller;

import java.io.Serializable;
import java.util.Map;
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
	
	public void addProcesso(long numero, String cadRF_cliente, String cadRF_prt_contraria) {
		Cliente cli = MainController.getClienteController().getCliente(cadRF_cliente);
		Pessoa contr = MainController.getPessoaController().getPessoa(cadRF_prt_contraria);
		Processo p = new Processo(numero, cli, contr);
		this.processos.put(p.getNumero(), p);
	}

}

