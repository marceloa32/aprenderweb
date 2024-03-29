package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.TipoBD;
import br.com.caelum.jdbc.exception.DAOException;
import br.com.caelum.jdbc.modelo.Contato;

/**
 * FJ-21 14.5.2 exr. 2.11
 *
 */
public class ContatoDAO {
	
	private Connection connection;
	
	public ContatoDAO(TipoBD tipoBd) {
		this.connection = new ConnectionFactory().getConnection(tipoBd);
	}
	
	public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		
		String sql = "insert into contatos(nome, email, endereco, dataNascimento) values (?,?,?,?)";
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}
	
	//exr 2.15-3
	public List<Contato> getLista(){
		return getLista("");
	}
	
	//exr 2.15-3
	public List<Contato> getLista(String condicao){
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			
			String sql = "select * from contatos";
			
			if(condicao.length() > 0) {
				sql += " where " + condicao;
			}
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				//montar a data com o Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contato.setDataNascimento(data);
				
				//adicionar objeto a lista
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			
			return contatos;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 * exr 2.15-4 
	 * @param id
	 * @return
	 */
	public Contato pesquisar(long id) {
		
		try {
			
			Contato contato = null;
			String sql = "select * from contatos where id = ?";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1,id);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				//montar a data com o Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contato.setDataNascimento(data);
			}
			
			rs.close();
			stmt.close();
			
			return contato;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 * exr 2.17 1
	 */
	public void altera(Contato contato) {
		String sql = "update contatos set nome = ?, email = ?, endereco = ?, dataNascimento = ? where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 * exr 2.17 2 
	 */
	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id = ?");			
			stmt.setLong(1, contato.getId());
			stmt.execute();
			
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	

}
