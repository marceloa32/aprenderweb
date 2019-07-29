package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		
		System.out.println("Conectando ao banco");
		
		try {
			return DriverManager.getConnection("jdbc:mysql://192.168.1.18/teste_ma", "root", "mestre");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
