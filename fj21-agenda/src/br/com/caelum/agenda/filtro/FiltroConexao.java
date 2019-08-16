package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.com.caelum.jdbc.ConnectionFactory;

public class FiltroConexao implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			
			//pendurar a conexao na requisicao
			req.setAttribute("conexao", conn);
			
			chain.doFilter(req, resp);
			
			conn.close();
			
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	@Override
	public void init(FilterConfig conf) throws ServletException {}

}
