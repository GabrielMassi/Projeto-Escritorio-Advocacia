package controller;

import java.io.Serializable;
import java.util.Map;
//import java.util.Set;
import java.util.TreeMap;

import model.*;

public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1945660900431033557L;

	private Map<String, Cliente> clientes;

	public ClienteController() {
		clientes = new TreeMap<>();
	}
	
	public Cliente getCliente(String cadastro) {
		Cliente c = this.clientes.get(cadastro);
		if(c != null){
			return this.clientes.get(cadastro);
		}else {
			throw new RuntimeException("Cliente não cadastrado. Deseja realizar este cadastro?");
		}
	}
	
	public void addCliente(String cadastro) {
		Pessoa p = MainController.getPessoaController().getPessoa(cadastro);
		Cliente c = new Cliente(p);
		this.clientes.put(c.getPessoa().getCadastroRF(), c);
	}
	
	public StringBuilder listar() {
		
		StringBuilder sb = new StringBuilder();
		
		for (Map.Entry<String, Cliente> c: clientes.entrySet()) {
			
			sb.append("Nome: " + c.getValue().getPessoa().getNome());
			sb.append("\nCPF/CNPJ: " + c.getValue().getPessoa().getCadastroRF());
			sb.append("\nEmail: " + c.getValue().getPessoa().getEmail());
			sb.append("\nTelefone: " + c.getValue().getPessoa().getTelefone());
			sb.append("\nProcessos abertos: " + c.getValue().processosAbertos());
			sb.append("\nSaldo: " + c.getValue().getSaldoContas() + "\n\n");
						
		}
		
		return sb;
		
	}
	
}