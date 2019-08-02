package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.exception.DAOException;
import br.com.caelum.jdbc.modelo.Funcionario;

/**
 * FJ-21 14.5.2 exr. 2.17 6
 *
 */
public class FuncionarioDAO {
	
	private Connection connection;
	
	public FuncionarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Funcionario funcionario) {
		
		String sql = "insert into Funcionarios(nome, usuario, senha) values (?,?,?)";
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}
	
	public List<Funcionario> getLista(){
		return getLista("");
	}
	
	public List<Funcionario> getLista(String condicao){
		try {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			
			String sql = "select * from funcionarios";
			
			if(condicao.length() > 0) {
				sql += " where " + condicao;
			}
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Funcionario func = new Funcionario();
				func.setId(rs.getLong("id"));
				func.setNome(rs.getString("nome"));
				func.setUsuario(rs.getString("usuario"));
				func.setSenha(rs.getString("senha"));
				
				//adicionar objeto a lista
				funcionarios.add(func);
			}
			
			rs.close();
			stmt.close();
			
			return funcionarios;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**

	 * @param id
	 * @return
	 */
	public Funcionario pesquisar(long id) {
		
		try {
			
			Funcionario func = null;
			String sql = "select * from funcionarios where id = ?";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1,id);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				func = new Funcionario();
				func.setId(rs.getLong("id"));
				func.setNome(rs.getString("nome"));
				func.setUsuario(rs.getString("usuario"));
				func.setSenha(rs.getString("senha"));
				
			}
			
			rs.close();
			stmt.close();
			
			return func;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 */
	public void altera(Funcionario funcionario) {
		String sql = "update funcionarios set nome = ?, usuario = ?, senha = ? where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());			
			stmt.setLong(4, funcionario.getId());
			stmt.execute();
			
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * 
	 */
	public void remove(Funcionario funcionario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from funcionarios where id = ?");			
			stmt.setLong(1, funcionario.getId());
			stmt.execute();
			
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	

}
