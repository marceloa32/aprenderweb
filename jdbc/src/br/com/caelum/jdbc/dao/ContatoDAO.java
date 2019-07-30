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
import br.com.caelum.jdbc.exception.DAOException;
import br.com.caelum.jdbc.modelo.Contato;

/**
 * FJ-21 14.5.2 exr. 2.11
 * @author Marcelo
 *
 */
public class ContatoDAO {
	
	private Connection connection;
	
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
	
	//exr 2.11
	public List<Contato> getLista(){
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			
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

}
