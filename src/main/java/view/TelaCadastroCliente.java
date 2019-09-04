package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.EnderecoController;
import controller.TelefoneController;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Telefone;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;

public class TelaCadastroCliente {

	private JFrame frmCadastroDeCliente;
	private JTable tableTelefones;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textSobrenome;
	private JTextField textCodPais;
	private JTextField textDDD;
	private JTextField textNumeroTelefone;
	private String [] colunasTabelaTelefones = {"País", "DDD", "Número", "Tipo"};
	private ArrayList<Telefone>	telefonesDoNovoCliente;
	private ArrayList<Endereco> todosOsEnderecos;
	private String[] tipos = {TelefoneController.TIPO_TELEFONE_FIXO, TelefoneController.TIPO_TELEFONE_MOVEL};
	private Cliente novoCliente = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente window = new TelaCadastroCliente();
					window.frmCadastroDeCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeCliente = new JFrame();
		frmCadastroDeCliente.setFont(new Font("Dialog", Font.BOLD, 12));
		frmCadastroDeCliente.setTitle("Cadastro de Cliente");
		frmCadastroDeCliente.setBounds(100, 100, 600, 400);
		frmCadastroDeCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeCliente.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 14, 46, 14);
		frmCadastroDeCliente.getContentPane().add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(66, 11, 127, 20);
		frmCadastroDeCliente.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(204, 14, 60, 14);
		frmCadastroDeCliente.getContentPane().add(lblSobrenome);
		
		textSobrenome = new JTextField();
		textSobrenome.setBounds(274, 11, 137, 20);
		frmCadastroDeCliente.getContentPane().add(textSobrenome);
		textSobrenome.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(10, 39, 46, 14);
		frmCadastroDeCliente.getContentPane().add(lblCPF);

		textCPF = new JTextField();
		textCPF.setBounds(66, 36, 127, 20);
		frmCadastroDeCliente.getContentPane().add(textCPF);
		textCPF.setColumns(10);
		
		MaskFormatter mascaraCpf;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			textCPF = new JFormattedTextField(mascaraCpf);
		} catch (ParseException e) {
			
		}
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(204, 39, 60, 14);
		frmCadastroDeCliente.getContentPane().add(lblEndereco);
		
		JLabel lblNovoTelefone = new JLabel("Novo Telefone: ");
		lblNovoTelefone.setBounds(10, 101, 94, 14);
		frmCadastroDeCliente.getContentPane().add(lblNovoTelefone);
		
		JButton btnAdicionarTelefone = new JButton("Adicionar Telefone");
		btnAdicionarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionarTelefone.setBounds(168, 184, 138, 23);
		frmCadastroDeCliente.getContentPane().add(btnAdicionarTelefone);
		
		JLabel lblCodPais = new JLabel("Cod. Pa\u00EDs");
		lblCodPais.setBounds(10, 126, 75, 14);
		frmCadastroDeCliente.getContentPane().add(lblCodPais);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 156, 46, 14);
		frmCadastroDeCliente.getContentPane().add(lblTipo);
		
		JLabel lblDDD = new JLabel("DDD");
		lblDDD.setBounds(147, 126, 46, 14);
		frmCadastroDeCliente.getContentPane().add(lblDDD);
		
		JLabel lblNumero = new JLabel("N\u00BA");
		lblNumero.setBounds(247, 126, 17, 14);
		frmCadastroDeCliente.getContentPane().add(lblNumero);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController clienteController = new ClienteController();
				String nomeDigitado = textNome.getText();
				String sobrenomeDigitado = textSobrenome.getText();
				String cpfDigitado = textCPF.getText().replace("-", "").replace(".","");
				Endereco enderecoSelecionado = (Endereco) comboBoxEndereco.getSelectedItem();
				
				String mensagem = clienteController.validarCamposSalvar(nomeDigitado, sobrenomeDigitado, cpfDigitado, enderecoSelecionado);
				
				if(mensagem.isEmpty()) {
					novoCliente = new Cliente(nomeDigitado, sobrenomeDigitado, cpfDigitado, new ArrayList<Telefone>(), enderecoSelecionado);
					novoCliente = clienteController.salvar(novoCliente);
					
					if(novoCliente.getId() > 0) {
						btnAdicionarTelefone.setEnabled(true);
						btnSalvar.setEnabled(false);
					}
				}else {
					JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSalvar.setBounds(180, 64, 91, 23);
		frmCadastroDeCliente.getContentPane().add(btnSalvar);
		
		JLabel lblTelefones = new JLabel("Telefones");
		lblTelefones.setForeground(Color.BLACK);
		lblTelefones.setBackground(Color.WHITE);
		lblTelefones.setBounds(10, 206, 60, 14);
		frmCadastroDeCliente.getContentPane().add(lblTelefones);
		
		tableTelefones = new JTable();
		tableTelefones.setBounds(42, 236, 430, 125);
		frmCadastroDeCliente.getContentPane().add(tableTelefones);
		
		// Código do construtor da tela
		consultarEnderecos();
		JComboBox comboBoxEndereco = new JComboBox(todosOsEnderecos.toArray());
		comboBoxEndereco.setBounds(274, 35, 137, 22);
		comboBoxEndereco.setSelectedIndex(-1);
		frmCadastroDeCliente.getContentPane().add(comboBoxEndereco);
		
		
		
		
		textCodPais = new JTextField();
		textCodPais.setBounds(97, 123, 38, 20);
		frmCadastroDeCliente.getContentPane().add(textCodPais);
		textCodPais.setColumns(10);
		
		textDDD = new JTextField();
		textDDD.setBounds(189, 123, 46, 20);
		frmCadastroDeCliente.getContentPane().add(textDDD);
		textDDD.setColumns(10);
		
		textNumeroTelefone = new JTextField();
		textNumeroTelefone.setBounds(271, 123, 140, 20);
		frmCadastroDeCliente.getContentPane().add(textNumeroTelefone);
		textNumeroTelefone.setColumns(10);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(96, 150, 86, 22);
		frmCadastroDeCliente.getContentPane().add(comboBoxTipo);
		String tipo[] = new String[2];
		tipo = {"Móvel", "Fixo"};
	}

	private void consultarEnderecos() {
		EnderecoController controller = new EnderecoController();
		todosOsEnderecos = controller.consultarTodos();
		
	}
	
	
}
