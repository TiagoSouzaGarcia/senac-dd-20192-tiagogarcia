package controller;

import model.bo.ClienteBO;
import model.entity.Cliente;

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

}
