package controller;

import model.bo.ClienteBO;
import model.entity.Cliente;
import model.entity.Endereco;

public class ClienteController {
	
	private ClienteBO bo = new ClienteBO();
	
	public ClienteController() {
		
	}
	
	public String salvar (String nome, String sobrenome, String cpf) {
		StringBuilder sb = new StringBuilder();
		
		validarNome(nome, sb);
		validarCPF(cpf, sb);
		
		if(sb.toString().isEmpty()) {
			novoCliente.setNome(nome);
			novoCliente.setSobrenome(sobrenome);
			novoCliente.setCpf(cpf);
			
			sb = new StringBuilder(bo.savar(novoCliente));
			
		}
		
		return sb.toString();
	}
	
	public String excluir (Cliente cliente) {
		return bo.excluir(cliente);
	}

	private void validarCPF(String cpf, StringBuilder sb) {
		if(cpf == null || cpf.trim().length() != 11) {
			sb.append("CPF deve conter 11 caracteres \n");
		} else {
			try {
				Long.parseLong(cpf);
			} catch(NumberFormatException ex) {
				sb.append("CPF deve conter somente números \n");
			}
		}
		
	}

	private void validarNome(String nome, StringBuilder sb) {
		if(nome == null  nome.trim().length() < 3) {
			sb.append("Nome deve conter no mínimo 3 caracteres \n");
		}
		
	}

	public void salvarCliente() {
		// TODO Auto-generated method stub
		
	}

	public String validarCamposSalvar(String nomeDigitado, String sobrenomeDigitado, String cpfDigitado,
			Endereco enderecoSelecionado) {
		
		String mensagem = "";
		
		if(nomeDigitado.isEmpty() || nomeDigitado.trim().length() < 3) {
			mensagem += "Nome deve possuir pelo menos 3 letras \n";
		}
		
		if(sobrenomeDigitado.isEmpty() || sobrenomeDigitado.trim().length() < 3) {
			mensagem += "Sobrenome deve possuir pelo menos 3 letras \n";
		}
		
		if(cpfDigitado.isEmpty() || cpfDigitado.trim().length() !=11) {
			mensagem += "CPF deve possuir 11 dígitos \n";
		}
		
		if(enderecoSelecionado == null) {
			mensagem += "Selecione um endereço \n";
		}
		// TODO Auto-generated method stub
		return mensagem;
	}

	public Cliente salvar(Cliente novoCliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
