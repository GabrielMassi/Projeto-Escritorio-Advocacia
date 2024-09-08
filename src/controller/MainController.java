package controller;

import java.io.Serializable;

import persistence.Serializer;

/* 
 * Design Pattern Singleton 
 */
public class MainController implements Serializable {

	private static final long serialVersionUID = 6341528978400871936L;

	private static MainController instance;

	
	private ProcessoController processoController;

	private PessoaController pessoaController;
	
	private ClienteController clienteController;
	
	private AdvogadoController advogadoController;
	
	private AudienciaController audienciaController;
	
	private ContaController contaController;

	private TribunalController tribunalController;


	
	private MainController() {
		
		 processoController = new  ProcessoController();
		
		   pessoaController = new    PessoaController();
		
		  clienteController = new   ClienteController();
		
		 advogadoController = new  AdvogadoController();
		
		audienciaController = new AudienciaController();
		
		    contaController = new     ContaController();
		
		 tribunalController = new  TribunalController();
		
		// instanciar os controladores
		
	}

	public static MainController getInstance() {
		return instance;
	}

	
	public static ProcessoController getProcessoController() {
		return instance.processoController;
	}
	
	public static PessoaController getPessoaController() {
		return instance.pessoaController;
	}
	
	public static ClienteController getClienteController() {
		return instance.clienteController;
	}
	
	public static AdvogadoController getAdvogadoController() {
		return instance.advogadoController;
	}
	
	public static AudienciaController getAudienciaController() {
		return instance.audienciaController;
	}
	
	public static ContaController getContaController() {
		return instance.contaController;
	}

	public static TribunalController getTribunalController() {
		return instance.tribunalController;
	}
	

	// implementar metodos acessadores estaticos para os demais controladores
	
	
	public static void load() {

		instance = Serializer.readFile();

		if (instance == null) {
			instance = new MainController();
		}
	}

	public static void save() {
		Serializer.writeFile(instance);
	}
}
