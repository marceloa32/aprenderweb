package br.com.fj21.mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fj21.mvc.logica.Logica;

public class ControllerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String parametro = req.getParameter("logica");
		String nomeDaClasse = "br.com.fj21.mvc.logica."+parametro;
		                       
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			String redireciona = logica.executa(req, resp);
			
			RequestDispatcher rd = req.getRequestDispatcher(redireciona);
			rd.forward(req, resp);
		} catch (ClassNotFoundException e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		} catch (InstantiationException e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		} catch (IllegalAccessException e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}
}
