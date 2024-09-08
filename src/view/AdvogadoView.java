package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import javax.swing.SwingConstants;

public class AdvogadoView extends JFrame {

	private static final long serialVersionUID = -5659880888694503154L;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public AdvogadoView() {
		initialize();
	}
	
	private void initialize() {
		setTitle("Tribunais");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 281);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(26, 33, 55, 15);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(218, 48, 145, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lbloab = new JLabel("OAB");
		lbloab.setBounds(218, 33, 55, 15);
		contentPane.add(lbloab);
		
		textField_1 = new JTextField();
		textField_1.setBounds(26, 48, 180, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(26, 79, 55, 15);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(218, 94, 145, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(218, 79, 55, 15);
		contentPane.add(lblTelefone);
		
		textField_3 = new JTextField();
		textField_3.setBounds(26, 94, 180, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(26, 141, 337, 100);
		contentPane.add(textArea);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(384, 45, 98, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(384, 91, 98, 25);
		contentPane.add(btnEditar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(375, 141, 107, 25);
		contentPane.add(btnListar);
		
		JButton btnBuscarcpf = new JButton("Buscar (CPF)");
		btnBuscarcpf.setBounds(365, 216, 118, 25);
		contentPane.add(btnBuscarcpf);
		
		textField_4 = new JTextField();
		textField_4.setBounds(365, 193, 117, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}
