package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		//Model
		System.out.println("Executando a lógica e redirecionando...");
		
		return "/primeira-logica.jsp";		
	}

}
