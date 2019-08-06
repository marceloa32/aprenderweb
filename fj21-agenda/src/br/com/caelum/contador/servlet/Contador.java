package br.com.caelum.contador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FJ-21 5.15
 *
 */
public class Contador extends HttpServlet{

	private int contador = 0;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config); //chamar o metodo da classe pai
		log("Iniciando a servlet");
	}
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		contador++; //a cada requisicao a mesma variavel e' incrementada
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>FJ-21: Contador</title></head>");
		out.println("<body>");
		out.println("Contador agora é: " + contador);
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		log("Destruindo a servlet");		
	}
}
