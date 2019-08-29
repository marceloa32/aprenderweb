package br.com.fj21.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import br.com.fj21.produto.dao.ProdutoDAO;
import br.com.fj21.produto.modelo.Produto;

public class AdicionaAlteraProdutoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		Produto produto = new Produto();
		produto.setNome(req.getParameter("nome"));
		produto.setDescricao(req.getParameter("descricao"));
		produto.setPreco(Double.parseDouble(req.getParameter("preco")));
		
		Session session = (Session) req.getAttribute("session");		
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.setSession(session);
		if(req.getParameter("id") != null) {
			produto.setId(Long.parseLong(req.getParameter("id")));
			dao.atualizar(produto);
			System.out.println("Alterando produto " + produto.getNome() +"...");
		} else { 
			dao.gravar(produto);
			System.out.println("Adicionando produto " + produto.getNome() +"...");
		}
		
		return "/lista-produtos.jsp";
	}

}
