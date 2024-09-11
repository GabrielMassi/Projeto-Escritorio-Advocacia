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
import util.EFormaPagamento;

import javax.swing.JComboBox;

public class VerProcessoView extends JFrame{

	private static final long serialVersionUID = -5659880888694503154L;

	private JPanel contentPane;
	private JTextField textFieldDespesa;
	private JTextField textFieldValorDespesa;
	private JTextField textFieldRecomend;
	private JTextField textFieldValor;
	private JComboBox<String> comboBoxFase;
	private JComboBox<String> comboBoxForma;
	private long processo_num;

	
	public VerProcessoView(long a) {
		processo_num = a;
		setResizable(false);
		initialize();
	}
	
	private void initialize() {
		setTitle(MainController.getProcessoController().getProcesso(processo_num).nomeVS());

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 281);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		textFieldDespesa = new JTextField();
		textFieldDespesa.setBounds(12, 48, 204, 24);
		contentPane.add(textFieldDespesa);
		textFieldDespesa.setColumns(10);
		
		textFieldValorDespesa = new JTextField();
		textFieldValorDespesa.setColumns(10);
		textFieldValorDespesa.setBounds(228, 50, 111, 24);
		contentPane.add(textFieldValorDespesa);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(12, 34, 87, 15);
		contentPane.add(lblDescrio);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(228, 34, 55, 15);
		contentPane.add(lblValor);
		
		JButton btnNovaDespesa = new JButton("Nova despesa");
		btnNovaDespesa.setBounds(351, 47, 132, 25);
		btnNovaDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionNovaDespesa(textFieldDespesa.getText(), Double.parseDouble(textFieldValorDespesa.getText()));
				textFieldDespesa.setText(""); textFieldValorDespesa.setText("");
			}
		});
		contentPane.add(btnNovaDespesa);
		
		JLabel lblRecomend = new JLabel("Recomendação");
		lblRecomend.setBounds(12, 125, 111, 15);
		contentPane.add(lblRecomend);
		
		textFieldRecomend = new JTextField();
		textFieldRecomend.setColumns(10);
		textFieldRecomend.setBounds(12, 139, 327, 24);
		contentPane.add(textFieldRecomend);
		
		JButton btnNovaAudiencia = new JButton("Nova audiência");
		btnNovaAudiencia.setBounds(351, 138, 132, 25);
		btnNovaAudiencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionNovaAudiencia(textFieldRecomend.getText());
				textFieldRecomend.setText("");
			}
		});
		contentPane.add(btnNovaAudiencia);
		
		JLabel lblMetodo = new JLabel("Forma de pagamento");
		lblMetodo.setBounds(12, 84, 149, 15);
		contentPane.add(lblMetodo);
		
		JLabel lblValor_1 = new JLabel("Valor");
		lblValor_1.setBounds(228, 84, 55, 15);
		contentPane.add(lblValor_1);
		
		textFieldValor = new JTextField();
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(228, 100, 111, 24);
		contentPane.add(textFieldValor);
		
		JButton btnNovoPagamento = new JButton("Novo Pagamento");
		btnNovoPagamento.setBounds(351, 97, 132, 25);
		btnNovoPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionNovoPagamento(whichForma(comboBoxForma.getSelectedItem().toString()), Double.parseDouble(textFieldValor.getText()));
				textFieldDespesa.setText(""); textFieldValorDespesa.setText("");
			}
		});
		contentPane.add(btnNovoPagamento);
		
		JLabel lblFaseDoProcesso = new JLabel("Fase do processo");
		lblFaseDoProcesso.setBounds(351, 175, 111, 15);
		contentPane.add(lblFaseDoProcesso);
		
		comboBoxFase = new JComboBox();
		comboBoxFase.setBounds(351, 191, 111, 24);
		contentPane.add(comboBoxFase);
		
		JButton btnVerStatus = new JButton("Ver Status");
		btnVerStatus.setBounds(351, 244, 98, 25);
		contentPane.add(btnVerStatus);
		
		JTextArea textVerStatus = new JTextArea();
		textVerStatus.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textVerStatus);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(250, 250));
		scrollPane.setBounds(12, 174, 325, 102);
		contentPane.add(scrollPane);
		
		comboBoxForma = new JComboBox();
		comboBoxForma.setBounds(12, 99, 204, 24);
		fillF(comboBoxForma); //TODO
		contentPane.add(comboBoxForma);
				
		
		
	}
	
	private void actionNovaAudiencia(String recomend) {
		MainController.getProcessoController().getProcesso(processo_num).addAudiencia(recomend);
	}
	
	private void actionNovaDespesa(String descricao, double valor) {
		MainController.getProcessoController().getProcesso(processo_num).getConta().addDespesa(descricao, valor);
	}
	
	private void actionNovoPagamento(EFormaPagamento forma, double valor) {
		MainController.getProcessoController().getProcesso(processo_num).getConta().addPagamento(forma, valor);
	}
	
    public static EFormaPagamento whichForma(String label) {
    	if(label == EFormaPagamento.PIX.label)
    		return EFormaPagamento.PIX;
    	else if(label == EFormaPagamento.CHEQUE.label)
    		return EFormaPagamento.CHEQUE;
    	else if(label == EFormaPagamento.DINHEIRO.label)
    		return EFormaPagamento.DINHEIRO;
    	else if(label == EFormaPagamento.CREDITO.label)
    		return EFormaPagamento.CREDITO;
    	else
    		return EFormaPagamento.DEBITO;
    }
	
}
