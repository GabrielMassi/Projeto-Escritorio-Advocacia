package view;

//import java.awt.event.ActionEvent;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuView extends JFrame {

	private static final long serialVersionUID = -2113576277373274435L;

	private JPanel contentPane;


	public MenuView() {
		setResizable(false);
		initialize();
	}

	private void initialize() {

		setTitle("Phoenix Wright Advocacia");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.setContentPane(contentPane);	
		
		
		
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBounds(158, 116, 114, 25);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionClienteView();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnClientes);
		
		
		JButton btnProcessos = new JButton("Processos");
		btnProcessos.setBounds(158, 81, 114, 25);
		btnProcessos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionProcessoView();
			}
		});
		contentPane.add(btnProcessos);
		
		
		JButton btnTribunais = new JButton("Tribunais");
		btnTribunais.setBounds(158, 190, 114, 25);
		btnTribunais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionTribunalView();
			}
		});
		contentPane.add(btnTribunais);
		
		
		JButton btnAdvogados = new JButton("Advogados");
		btnAdvogados.setBounds(158, 153, 114, 25);
		btnAdvogados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionAdvogadoView();
			}
		});
		contentPane.add(btnAdvogados);

	}
	
	private void actionClienteView() {
		ClienteView clienteView = new ClienteView();
		clienteView.setVisible(true);
	}
	
	private void actionAdvogadoView() {
		AdvogadoView advogadoView = new AdvogadoView();
		advogadoView.setVisible(true);
	}
	
	private void actionProcessoView() {
		ProcessoView processoView = new ProcessoView();
		processoView.setVisible(true);
	}
	
	private void actionTribunalView() {
		TribunalView tribunalView = new TribunalView();
		tribunalView.setVisible(true);
	}
	
}
