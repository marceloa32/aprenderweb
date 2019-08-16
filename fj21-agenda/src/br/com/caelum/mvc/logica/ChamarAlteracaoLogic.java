package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class ChamarAlteracaoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		long id = Long.parseLong(req.getParameter("id"));
		ContatoDAO dao = new ContatoDAO();
		Contato c = dao.pesquisar(id);
		
		if(c != null) {
			System.out.println("Chamando alteracao do contato " + c.getNome() +"...");
			req.setAttribute("contato", c);
			return "/testa-altera-mvc.jsp";

		} else { 
			System.out.println("Nao achei o contato id = " + id);
			return "/erro.html";
		}
	}

}
