package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Telefone;

public class ClienteDAO implements BaseDAO<Cliente> {

	public Cliente salvar(Cliente novoCliente) {
		Connection conn = Banco.getConnection();
		String sql = " INSERT INTO CLIENTE (NOME, SOBRENOME, CPF, IDENDERECO) "
				+ " VALUES (?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			stmt.setString(1,  novoCliente.getNome());
			stmt.setString(2, novoCliente.getSobrenome());
			stmt.setString(3, novoCliente.getCpf());
			stmt.setInt(4, novoCliente.getEndereco().getId());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				int idGerado = rs.getInt(1);
				novoCliente.setId(idGerado);
			}
			TelefoneDAO telDAO = new TelefoneDAO();
			telDAO.ativarTelefones(novoCliente, novoCliente.getTelefones());;
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo Cliente.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return novoCliente;
	}

	public boolean excluir(int id) {
		TelefoneDAO tDAO = new TelefoneDAO();
		tDAO.desativarTelefones(id);
		
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM CLIENTE WHERE ID= " + id;
		Statement stmt = Banco.getStatement(conn);
		
		int quantidadeLinhasAfetadas = 0;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir cliente.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return quantidadeLinhasAfetadas > 0;
	}

	public boolean alterar(Cliente cliente) {
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE CLIENTE"
				+ "SET NOME=?, SOBRENOME=?, CPF=?, IDENDERECO=? "
				+ "WHERE ID = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		int registrosAlterados =0;
		try {
			stmt.setString(1,  cliente.getNome());
			stmt.setString(2, cliente.getSobrenome());
			stmt.setString(3, cliente.getCpf());
			stmt.setInt(4, cliente.getEndereco().getId());
			stmt.setInt(5, cliente.getId());
			registrosAlterados = stmt.executeUpdate();
			
			TelefoneDAO telDAO = new TelefoneDAO();
			telDAO.ativarTelefones(cliente,  cliente.getTelefones());			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo cliente.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return registrosAlterados > 0;
	}

	public Cliente consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		String sql = "SELECT id, nome, sobrenome, cpf, idendereco "
				+ "FROM CLIENTE "
				+ "WHERE ID= " + id;
		Statement stmt = Banco.getStatement(conn);
		Cliente cliente = null;
		
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);
			
			if(resultadoDaConsulta.next()) {
				cliente = construirClienteDoResultSet(resultadoDaConsulta);
				
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente por id = " + id);
			System.out.println("Erro: " + e.getMessage());
			
		}
		
		return cliente;
	}

	public ArrayList<Cliente> consultarTodos() {
		Connection conn = Banco.getConnection();
		String sql = "SELECT * FROM CLIENTE ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Cliente c = construirClienteDoResultSet(rs);
				clientes.add(c);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar clientes.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return clientes;
	}
	
	private Cliente construirClienteDoResultSet (ResultSet rs) {
		Cliente c = new Cliente();
		try {
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
			c.setSobrenome(rs.getString("sobrenome"));
			c.setCpf(rs.getString("cpf"));
			
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			Endereco end = enderecoDAO.consultarPorId(rs.getInt("idendereco"));
			c.setEndereco(end);
			
			TelefoneDAO telefoneDAO = new TelefoneDAO();
			ArrayList<Telefone> telefones = telefoneDAO.consultarTodosPorIdCliente(rs.getInt("id"));
			c.setTelefones(telefones);
			
		} catch (SQLException e) {
			System.out.println("Erro ao construir cliente a partir do ResultSet.");
			System.out.println("Erro: " + e.getMessage());
		}
		
	return null;
	}


}
