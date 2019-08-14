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
		return getConnection(TipoBD.MYSQL);
	}

	public Connection getConnection(TipoBD tipoBd) {
		
		System.out.println("Conectando ao banco");
		
		try {
			if(tipoBd == TipoBD.MYSQL) {
				return DriverManager.getConnection("jdbc:mysql://192.168.1.18/teste_ma", "root", "mestre");
			} else if (tipoBd == TipoBD.SQLSERVER) {
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				return DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.8:1433/teste_ma","sa", "mestre@2017");
			} else { 
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
