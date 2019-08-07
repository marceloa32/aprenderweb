package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * FJ-21 14.5.2 exr. 2.6
 *
 */
public class ConnectionFactory {

	public Connection getConnection() {
		
		System.out.println("Conectando ao banco");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://192.168.1.18/teste_ma", "root", "mestre");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
