package br.com.fj21.mvc.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;

import br.com.fj21.produto.dao.HibernateUtil;

public class FiltroConexao implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		Session session = new HibernateUtil().getSession();
		//pendurar a sessao na requisicao
		req.setAttribute("session", session);
		
		chain.doFilter(req, resp);
		
		session.close();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
