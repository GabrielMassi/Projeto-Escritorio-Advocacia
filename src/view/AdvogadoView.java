package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import controller.MainController;

public class AdvogadoView extends JFrame {

	private static final long serialVersionUID = -5659880888694503154L;

	private JPanel contentPane;
	private JTextField textFieldCadastro;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextArea listaAdv;
	private JTextField textFieldOab;
	private JTextArea textAreaCurriculo;
	
	public AdvogadoView() {
		setResizable(false);
		initialize();
	}
	
	private void initialize() {
		setTitle("Advogados");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 350);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 34, 55, 15);
		contentPane.add(lblNome);
		
		textFieldCadastro = new JTextField();
		textFieldCadastro.setBounds(204, 49, 145, 19);
		contentPane.add(textFieldCadastro);
		textFieldCadastro.setColumns(10);
		
		JLabel lblCadastro = new JLabel("CPF");
		lblCadastro.setBounds(204, 34, 55, 15);
		contentPane.add(lblCadastro);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(12, 49, 180, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 70, 55, 15);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(12, 85, 180, 19);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(204, 70, 55, 15);
		contentPane.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(204, 85, 145, 19);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(384, 45, 98, 25);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success = cadastrarAdvogado(textFieldNome.getText(), textFieldCadastro.getText(), textFieldEmail.getText(), textFieldTelefone.getText(), textFieldOab.getText(), textAreaCurriculo.getText());
				if(!success) {
					JOptionPane.showMessageDialog(contentPane, "Cadastro inválido ou já existente.", "", ERROR);
				}
				textFieldNome.setText("");textFieldCadastro.setText("");textFieldTelefone.setText("");textFieldEmail.setText("");textFieldOab.setText("");textAreaCurriculo.setText("");
				
			}
		});
		contentPane.add(btnCadastrar);
		
		
		
		listaAdv = new JTextArea();
		listaAdv.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(listaAdv);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(250, 250));
		scrollPane.setBounds(12, 227, 337, 111);
		contentPane.add(scrollPane);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(375, 227, 107, 25);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaAdv.setText("");
				listar(listaAdv);
			}
		});
		contentPane.add(btnListar);
		
		
		JLabel lbloab = new JLabel("OAB");
		lbloab.setBounds(12, 112, 55, 15);
		contentPane.add(lbloab);
		
		textFieldOab = new JTextField();
		textFieldOab.setColumns(10);
		textFieldOab.setBounds(12, 127, 180, 19);
		contentPane.add(textFieldOab);
		
		textAreaCurriculo = new JTextArea();
		textAreaCurriculo.setEditable(true);
		textAreaCurriculo.setBounds(12, 168, 470, 47);
		contentPane.add(textAreaCurriculo);
		
		JLabel lblCurriculo = new JLabel("Currículo breve");
		lblCurriculo.setBounds(12, 151, 200, 15);
		contentPane.add(lblCurriculo);
	}
	
	private boolean cadastrarAdvogado(String nome, String cadastro, String email, String telefone, String oab, String curriculo) {
		
		try {
			MainController.getAdvogadoController().addAdvogado(cadastro, oab, curriculo);
		}catch(Exception e) {
			try{
				
				MainController.getPessoaController().addPessoaFisica(nome, cadastro);
				
				
				if(!email.isBlank())
					MainController.getPessoaController().getPessoa(cadastro).setEmail(email);
				
				if(!telefone.isBlank())
					MainController.getPessoaController().getPessoa(cadastro).setTelefone(telefone);
								
				MainController.getAdvogadoController().addAdvogado(cadastro, oab, curriculo);
				
			}catch(Exception ee) {
				return false;
			}
		}
		
		return true;		
	}
	
	private void listar(JTextArea t) {
		t.append(MainController.getAdvogadoController().listar().toString());
	}


	
}
