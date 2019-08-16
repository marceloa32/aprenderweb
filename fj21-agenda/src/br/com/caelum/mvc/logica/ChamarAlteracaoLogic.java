package br.com.caelum.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class ChamarAlteracaoLogic implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		long id = Long.parseLong(req.getParameter("id"));
		ContatoDAO dao = new ContatoDAO();
		Contato c = dao.pesquisar(id);
		
		if(c != null) {
			req.setAttribute("contato", c);
			RequestDispatcher rd = req.getRequestDispatcher("/testa-altera-mvc.jsp");
			rd.forward(req, resp);
			
			System.out.println("Chamando alteracao do contato " + c.getNome() +"...");

		} else { 
			System.out.println("Nao achei o contato id = " + id);
		}
	}

}
