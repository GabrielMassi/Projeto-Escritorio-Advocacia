package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public class ProcessoView extends JFrame {

	private static final long serialVersionUID = -5659880888694503154L;

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JComboBox<String> comboBoxCliente;
	JComboBox<String> comboBoxPrtContraria;
	JComboBox<String> comboBoxTribunal;
	
	public ProcessoView() {
		setResizable(false);
		initialize();
	}
	
	private void initialize() {
		setTitle("Processo");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 350);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JTextArea listaProcessos = new JTextArea();
		listaProcessos.setBounds(12, 216, 337, 122);
		contentPane.add(listaProcessos);
		
		JButton btnNovoProcesso = new JButton("Novo Processo");
		btnNovoProcesso.setBounds(352, 25, 126, 25);
		btnNovoProcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionNovoProcesso(comboBoxCliente.getSelectedItem().toString().substring(0, 11), comboBoxPrtContraria.getSelectedItem().toString().substring(0, 11), comboBoxTribunal.getSelectedItem().toString());
			}
		});
		contentPane.add(btnNovoProcesso);
		
		JButton btnVerProcesso = new JButton("Ver Processo (n°)");
		btnVerProcesso.setBounds(120, 25, 142, 25);
		btnVerProcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionVerProcesso();
			}
		});
		contentPane.add(btnVerProcesso);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(12, 52, 55, 15);
		contentPane.add(lblCliente);
		
		comboBoxCliente = new JComboBox<>();
		comboBoxCliente.setBounds(12, 68, 328, 24);
		fillC(comboBoxCliente, MainController.getClienteController().getClientes().keySet());
		contentPane.add(comboBoxCliente);
		
		JLabel lblParteContraria = new JLabel("Parte Contrária");
		lblParteContraria.setBounds(12, 98, 121, 15);
		contentPane.add(lblParteContraria);
		
		comboBoxPrtContraria = new JComboBox<>();
		comboBoxPrtContraria.setBounds(12, 114, 328, 24);
		fillP(comboBoxPrtContraria, MainController.getPessoaController().getPessoas().keySet());
		contentPane.add(comboBoxPrtContraria);
		
		
		JLabel lblTribunal = new JLabel("Tribunal");
		lblTribunal.setBounds(12, 150, 121, 15);
		contentPane.add(lblTribunal);
		
		comboBoxTribunal = new JComboBox<String>();
		comboBoxTribunal.setBounds(12, 166, 328, 24);
		fillT(comboBoxTribunal, MainController.getTribunalController().getTribunais());
		contentPane.add(comboBoxTribunal);
		
		
		JLabel lblListarProcessosEm = new JLabel("Listar Processos em Fase:");
		lblListarProcessosEm.setBounds(194, 191, 154, 25);
		contentPane.add(lblListarProcessosEm);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(352, 191, 131, 25);
		btnListar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actionListar(buttonGroup, listaProcessos);
			}
		});
		contentPane.add(btnListar);
		
		
		JRadioButton rdbtnInicial = new JRadioButton("Inicial");
		buttonGroup.add(rdbtnInicial);
		rdbtnInicial.setBounds(357, 216, 121, 23);
		contentPane.add(rdbtnInicial);
		
		JRadioButton rdbtnInstrucao = new JRadioButton("Instrução");
		buttonGroup.add(rdbtnInstrucao);
		rdbtnInstrucao.setBounds(357, 243, 121, 23);
		contentPane.add(rdbtnInstrucao);
		
		JRadioButton rdbtnDecisao = new JRadioButton("Decisão");
		buttonGroup.add(rdbtnDecisao);
		rdbtnDecisao.setBounds(357, 270, 121, 23);
		contentPane.add(rdbtnDecisao);
		
		JRadioButton rdbtnRecurso = new JRadioButton("Recurso");
		buttonGroup.add(rdbtnRecurso);
		rdbtnRecurso.setBounds(357, 297, 121, 23);
		contentPane.add(rdbtnRecurso);
		
		JButton btnNovaPessoa = new JButton("Nova Pessoa");
		btnNovaPessoa.setBounds(352, 114, 131, 25);
		contentPane.add(btnNovaPessoa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(263, 25, 77, 24);
		contentPane.add(comboBox);
		
	}
	
	private void fillC(JComboBox<String> jcb, Set<String> set) {
		for (String cadastro : set) {
			jcb.addItem(cadastro + " - (" + MainController.getClienteController().getCliente(cadastro).getPessoa().getNome() + ")" );
		}
	}
	
	private void fillP(JComboBox<String> jcb, Set<String> set) {
		for (String cadastro : set) {
			jcb.addItem(cadastro + " - (" + MainController.getPessoaController().getPessoa(cadastro).getNome() + ")" );
		}
	}
	
	private void fillT(JComboBox<String> jcb, Set<String> set) {
		for (String cadastro : set) {
			jcb.addItem(cadastro);
		}
	}
	
	private void actionNovoProcesso(String cadClientes, String cadPrtContraria, String trib) {
		
		try {
			MainController.getProcessoController().addProcesso(cadClientes, cadPrtContraria, trib);
									
		}catch(RuntimeException e) {
			//TODO
		}
	}
	
	private void actionVerProcesso() {
		
	}
	
	private void actionListar(ButtonGroup bg, JTextArea t) {
		
		t.setText("");
		for (long p_num : MainController.getProcessoController().getProcessos()) {
			if(MainController.getProcessoController().getProcesso(p_num).getFase().label == getSelectedButtonText(bg) )
				t.append(MainController.getProcessoController().getProcesso(p_num).toString());
		}
		
	}
	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
}
