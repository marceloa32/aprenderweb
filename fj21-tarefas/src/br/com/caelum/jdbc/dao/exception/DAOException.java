package br.com.caelum.jdbc.dao.exception;

import java.sql.SQLException;

public class DAOException extends RuntimeException {

	public DAOException(SQLException e) {
		super(e);
	}

}
