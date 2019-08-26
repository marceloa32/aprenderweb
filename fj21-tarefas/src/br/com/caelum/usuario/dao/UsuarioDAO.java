package br.com.caelum.usuario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.caelum.tarefas.dao.jdbc.ConnectionFactory;
import br.com.caelum.usuario.modelo.Usuario;

public class UsuarioDAO {
	
	private Connection conn;

	public UsuarioDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}

	public boolean existeUsuario(Usuario usuario) {

		boolean existe = false;
		try {
			PreparedStatement ps = conn.prepareStatement("select login, senha from usuarios where login = ?");
			
			ps.setString(1, usuario.getLogin());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("senha").equals(usuario.getSenha())) {
					existe = true;
				}
			}
			
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return existe;

	}

}
