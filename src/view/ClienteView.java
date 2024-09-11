package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import java.awt.Component;

public class ClienteView extends JFrame {

	private static final long serialVersionUID = -5659880888694503154L;

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCadastro;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldBuscaCad;
	private JTextArea listaClientes;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public ClienteView() {
		setResizable(false);
		initialize();
	}
	
	private void initialize() {
		setTitle("Cliente");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 281);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
				
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 36, 55, 15);
		contentPane.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(12, 51, 180, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JRadioButton rdbtnCpf = new JRadioButton("CPF");
		buttonGroup.add(rdbtnCpf);
		rdbtnCpf.setBounds(204, 28, 55, 23);
		contentPane.add(rdbtnCpf);
		
		JRadioButton rdbtnCnpj = new JRadioButton("CNPJ");
		buttonGroup.add(rdbtnCnpj);
		rdbtnCnpj.setBounds(284, 28, 65, 23);
		contentPane.add(rdbtnCnpj);
		
		textFieldCadastro = new JTextField();
		textFieldCadastro.setBounds(204, 51, 145, 19);
		contentPane.add(textFieldCadastro);
		textFieldCadastro.setColumns(10);
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 82, 55, 15);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(12, 97, 180, 19);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(204, 82, 55, 15);
		contentPane.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(204, 97, 145, 19);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(384, 45, 98, 25);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success = cadastrarCliente(textFieldNome.getText(), textFieldCadastro.getText(), textFieldTelefone.getText(), textFieldEmail.getText(), buttonGroup.isSelected(rdbtnCpf.getModel()));
				if(!success) {
					JOptionPane.showMessageDialog(contentPane, "Cadastro inválido ou já existente.", "", ERROR);
				}
				textFieldNome.setText("");textFieldCadastro.setText("");textFieldTelefone.setText("");textFieldEmail.setText("");
				
			}
		});
		contentPane.add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(384, 91, 98, 25);
		contentPane.add(btnEditar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(375, 141, 107, 25);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaClientes.setText("");
				listar(listaClientes);
			}
		});
		contentPane.add(btnListar);
		
		JButton btnBuscarcpf = new JButton("Buscar");
		btnBuscarcpf.setBounds(365, 216, 118, 25);
		contentPane.add(btnBuscarcpf);
		
		textFieldBuscaCad = new JTextField();
				textFieldBuscaCad.setBounds(365, 193, 117, 19);
		contentPane.add(textFieldBuscaCad);
		textFieldBuscaCad.setColumns(10);
		textFieldBuscaCad.setToolTipText("CPF ou CNPJ");

		listaClientes = new JTextArea();
		listaClientes.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(listaClientes);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(250, 250));
		scrollPane.setBounds(12, 141, 337, 111);
		contentPane.add(scrollPane);
		
	}
	
	private boolean cadastrarCliente(String nome, String cadastro, String email, String telefone, boolean is_a_cpf) {
		
		try {
			MainController.getClienteController().addCliente(cadastro);
		}catch(Exception e) {
			try{
				if(is_a_cpf)
					MainController.getPessoaController().addPessoaFisica(nome, cadastro);
				else
					MainController.getPessoaController().addPessoaJuridica(nome, cadastro);
				
				if(!email.isBlank())
					MainController.getPessoaController().getPessoa(cadastro).setEmail(email);
				
				if(!telefone.isBlank())
					MainController.getPessoaController().getPessoa(cadastro).setTelefone(telefone);
								
				MainController.getClienteController().addCliente(cadastro);
				
			}catch(Exception ee) {
				return false;
			}
		}
		
		return true;		
	}
	
	public void listar(JTextArea t) {
		t.append(MainController.getClienteController().listar().toString());
	}
}
