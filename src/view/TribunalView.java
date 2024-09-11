package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import controller.MainController;

public class TribunalView extends JFrame {

	private static final long serialVersionUID = -5659880888694503154L;

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldSigla;
	private JTextField textFieldSecao;
	private JTextArea listaTrib;
	
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
		
		textFieldSigla = new JTextField();
		textFieldSigla.setBounds(26, 48, 55, 19);
		contentPane.add(textFieldSigla);
		textFieldSigla.setColumns(10);
		
				
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(99, 33, 55, 15);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(99, 48, 145, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		
		JLabel lblSecao = new JLabel("Seção");
		lblSecao.setBounds(256, 33, 107, 15);
		contentPane.add(lblSecao);
		
		textFieldSecao = new JTextField();
		textFieldSecao.setBounds(256, 48, 107, 19);
		contentPane.add(textFieldSecao);
		textFieldSecao.setColumns(10);
		
		
		listaTrib = new JTextArea();
		listaTrib.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(listaTrib);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(250, 250));
		scrollPane.setBounds(12, 141, 337, 128);
		contentPane.add(scrollPane);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(384, 45, 98, 25);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCadastrar(textFieldSigla.getText(), textFieldNome.getText(), textFieldSecao.getText());
				textFieldSigla.setText(""); textFieldNome.setText(""); textFieldSecao.setText("");
			}
		});
		contentPane.add(btnCadastrar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(375, 141, 107, 25);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar(listaTrib);
			}
		});
		contentPane.add(btnListar);
	}
	
	private void actionCadastrar(String sigla, String nome, String secao) {
		MainController.getTribunalController().addTribunal(sigla, nome, secao);
	}
	
	private void actionListar(JTextArea t) {
		t.setText(MainController.getTribunalController().listar().toString());
	}
}
