package model.dao.lista01;

import java.util.ArrayList;

public interface BaseDAO<T> {

	public T salvar (T novaEntidade);
	
	public boolean excluir(int id);
	
	public boolean alterar (T entidade);
	
	public T consultarPorId(int id);
	
	public ArrayList<T> consultarTodos();
}
