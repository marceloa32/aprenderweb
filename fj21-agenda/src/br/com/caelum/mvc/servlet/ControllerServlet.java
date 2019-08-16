package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

public class ControllerServlet extends HttpServlet {

	//Controller
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String parametro = req.getParameter("logica");
		String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro;
		
		try {
			Class classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			String redireciona = logica.executa(req, resp);
			
			RequestDispatcher rd = req.getRequestDispatcher(redireciona);
			rd.forward(req, resp);
		} catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}
}
