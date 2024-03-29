package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class RemoverContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		long id = Long.parseLong(req.getParameter("id"));
		
		//-----
		//exr 10.6
		Connection conn = (Connection) req.getAttribute("conexao");
		ContatoDAO dao = new ContatoDAO(conn);
		
		Contato contato = dao.pesquisar(id);
		
		if( contato != null) {
			dao.remove(contato);			
		}
		
		//-----
		System.out.println("Removendo contato " + contato.getNome() +"...");
		return "/lista-contatos-elegante.jsp";

	}

}
