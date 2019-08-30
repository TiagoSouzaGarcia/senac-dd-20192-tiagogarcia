package model.dao.lista01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.Banco;
import model.entity.lista01.Empregado;

public class EmpregadoDAO implements BaseDAO<Empregado>{

	public Empregado salvar(Empregado emp) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO EMPREGADO (NOME, CPF, SEXO "
				+ " IDADE, SALARIOBRUTO, DESCONTOIMPOSTORENDA, DESCONTOPREVIDENCIA "
				+ " SALARIOBASE, SALARIO, COMISSAO, TIPO) "
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
		
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			
		
		stmt.setString(1,  emp.getNome());
		stmt.setString(2, emp.getCpf());
		stmt.setString(3, emp.getSexo() + "");
		stmt.setInt(4, emp.getIdade());
		stmt.
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean alterar(Empregado entidade) {
		// TODO Auto-generated method stub
		return false;
	}

	public Empregado consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
