package br.com.fj21.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import br.com.fj21.produto.dao.ProdutoDAO;
import br.com.fj21.produto.modelo.Produto;

public class ChamarAlteracaoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		long id = Long.parseLong(req.getParameter("id"));
		
		Session session = (Session) req.getAttribute("session");		
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.setSession(session);
		Produto procurado = dao.pesquisar(id);
		
		if(procurado == null) {
			System.out.println("Produto não localizado! id="+id);
			return "/erro.html";
		} else { 
			req.setAttribute("produto", procurado);
			return "/altera-produto.jsp";
		}
	}

}
