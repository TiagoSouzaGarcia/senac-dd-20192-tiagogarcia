package model.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.entity.Telefone;

public class TelefoneDAO implements BaseDAO<Telefone>{

	public Telefone salvar(Telefone novaTelefone) {
		Connection conn = Banco.getConnection();
		
		String sql = "INSERT INTO TELEFONE VALUES (?, ?, ?, ?, ?)"; 
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		return null;
	}

	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean alterar(Telefone entidade) {
		// TODO Auto-generated method stub
		return false;
	}

	public Telefone consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Telefone> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
