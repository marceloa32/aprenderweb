package br.com.caelum.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class RemoverContatoLogic implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		long id = Long.parseLong(req.getParameter("id"));
		
		//-----
		ContatoDAO dao = new ContatoDAO();
		
		Contato contato = dao.pesquisar(id);
		
		if( contato != null) {
			dao.remove(contato);			
		}
		
		//-----
		RequestDispatcher rd = req.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(req, resp);
		
		System.out.println("Removendo contato " + contato.getNome() +"...");

	}

}
