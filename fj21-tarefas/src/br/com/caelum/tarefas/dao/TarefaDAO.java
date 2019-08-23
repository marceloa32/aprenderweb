package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.dao.exception.DAOException;
import br.com.caelum.tarefas.dao.jdbc.ConnectionFactory;
import br.com.caelum.tarefas.modelo.Tarefa;

//adaptados do projeto fj21-agenda pq nao tenho o zip da escola
public class TarefaDAO {

private Connection connection;
	
	public TarefaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Tarefa tarefa) {
		
		String sql = "insert into tarefas(descricao, finalizado, dataFinalizacao) values (?,?,?)";
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			if(tarefa.getDataFinalizacao() == null) { 
				stmt.setDate(3,  null);
			} else {				
				stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			}
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}
	
	public List<Tarefa> getLista(){
		return getLista("");
	}

	public List<Tarefa> getLista(String condicao){
		try {
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			
			String sql = "select * from tarefas";
			
			if(condicao.length() > 0) {
				sql += " where " + condicao;
			}
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
								
				//montar a data com o Calendar
				if(rs.getDate("dataFinalizacao") != null) {					
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataFinalizacao"));
					tarefa.setDataFinalizacao(data);
				}
				
				//adicionar objeto a lista
				tarefas.add(tarefa);
			}
			
			rs.close();
			stmt.close();
			
			return tarefas;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 * exr 2.15-4 
	 * @param id
	 * @return
	 */
	public Tarefa pesquisar(long id) {
		
		try {
			
			Tarefa tarefa = null;
			String sql = "select * from tarefas where id = ?";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1,id);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("decricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				
				//montar a data com o Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataFinalizacao"));
				tarefa.setDataFinalizacao(data);
			}
			
			rs.close();
			stmt.close();
			
			return tarefa;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public void altera(Tarefa tarefa) {
		String sql = "update tarefas set descricao = ?, finalizado = ?, dataFinalizacao= ? where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());			
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stmt.setLong(4, tarefa.getId());
			stmt.execute();
			
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void remove(Tarefa tarefa) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tarefaas where id = ?");			
			stmt.setLong(1, tarefa.getId());
			stmt.execute();
			
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	

}
