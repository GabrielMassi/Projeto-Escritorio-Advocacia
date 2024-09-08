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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public class ProcessoView extends JFrame {

	private static final long serialVersionUID = -5659880888694503154L;

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public ProcessoView() {
		initialize();
	}
	
	private void initialize() {
		setTitle("Processo");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 281);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 169, 337, 100);
		contentPane.add(textArea);
		
		JButton btnNovoProcesso = new JButton("Novo Processo");
		btnNovoProcesso.setBounds(352, 98, 131, 25);
		btnNovoProcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionNovoProcesso();
			}
		});
		contentPane.add(btnNovoProcesso);
		
		JButton btnVerProcesso = new JButton("Ver Processo");
		btnVerProcesso.setBounds(352, 46, 131, 25);
		btnVerProcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionVerProcesso();
			}
		});
		contentPane.add(btnVerProcesso);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(12, 30, 55, 15);
		contentPane.add(lblCliente);
		
		JComboBox<String> comboBoxCliente = new JComboBox<>();
		comboBoxCliente.setBounds(12, 46, 328, 24);
		contentPane.add(comboBoxCliente);
		
		JLabel lblParteContraria = new JLabel("Parte Contrária");
		lblParteContraria.setBounds(12, 82, 121, 15);
		contentPane.add(lblParteContraria);
		
		JComboBox<String> comboBoxPrtContraria = new JComboBox<>();
		comboBoxPrtContraria.setBounds(12, 98, 328, 24);
		contentPane.add(comboBoxPrtContraria);
		
		
		
		
		
		JLabel lblListarProcessosEm = new JLabel("Listar Processos em Fase:");
		lblListarProcessosEm.setBounds(194, 144, 154, 25);
		contentPane.add(lblListarProcessosEm);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(352, 144, 131, 25);
		contentPane.add(btnListar);
		
		
		JRadioButton rdbtnInicial = new JRadioButton("Inicial");
		buttonGroup.add(rdbtnInicial);
		rdbtnInicial.setBounds(357, 169, 121, 23);
		rdbtnInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar(0);
			}
		});
		contentPane.add(rdbtnInicial);
		
		JRadioButton rdbtnInstrucao = new JRadioButton("Instrução");
		buttonGroup.add(rdbtnInstrucao);
		rdbtnInstrucao.setBounds(357, 196, 121, 23);
		rdbtnInstrucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar(1);
			}
		});
		contentPane.add(rdbtnInstrucao);
		
		JRadioButton rdbtnDecisao = new JRadioButton("Decisão");
		buttonGroup.add(rdbtnDecisao);
		rdbtnDecisao.setBounds(357, 223, 121, 23);
		rdbtnDecisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar(2);
			}
		});
		contentPane.add(rdbtnDecisao);
		
		JRadioButton rdbtnRecurso = new JRadioButton("Recurso");
		buttonGroup.add(rdbtnRecurso);
		rdbtnRecurso.setBounds(357, 250, 121, 23);
		rdbtnRecurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar(3);
			}
		});
		contentPane.add(rdbtnRecurso);
		
	}
	
	private void actionNovoProcesso() {
		
	}
	
	private void actionVerProcesso() {
		
	}
	
	private void actionListar(int a) {
		
	}
}
