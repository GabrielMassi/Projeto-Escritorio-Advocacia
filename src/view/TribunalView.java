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

public class TribunalView extends JFrame {

	private static final long serialVersionUID = -5659880888694503154L;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	
	public TribunalView() {
		setResizable(false);
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
		
		JLabel lblSigla = new JLabel("Sigla");
		lblSigla.setBounds(26, 33, 55, 15);
		contentPane.add(lblSigla);
		
		textField = new JTextField();
		textField.setBounds(99, 48, 145, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(99, 33, 55, 15);
		contentPane.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(26, 48, 55, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSecao = new JLabel("Seção");
		lblSecao.setBounds(256, 33, 107, 15);
		contentPane.add(lblSecao);
		
		textField_3 = new JTextField();
		textField_3.setBounds(256, 48, 107, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(26, 141, 337, 100);
		contentPane.add(textArea);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(384, 45, 98, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(375, 141, 107, 25);
		contentPane.add(btnListar);
	}
}
