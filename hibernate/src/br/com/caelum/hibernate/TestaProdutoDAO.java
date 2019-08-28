package br.com.caelum.hibernate;

import org.hibernate.Session;

import br.com.caelum.hibernate.dao.ProdutoDAO;

public class TestaProdutoDAO {
	
	public static void main(String[] args) {
		
		Session session = new HibernateUtil().getSession();
		
		ProdutoDAO dao = new ProdutoDAO(session);
		Produto produto = new Produto();
		
		produto.setNome("PROD_6");
		produto.setDescricao("Produto 6");
		produto.setPreco(14.47);
		
		session.beginTransaction();
		dao.salva(produto);
		session.getTransaction().commit();
		
		
		Produto p6 = dao.procura(6L);
		if(p6 != null) {
			System.out.println(p6.getNome() + " " + p6.getDescricao());
		}
		Produto p7 = dao.procura(7L);
		if(p7 != null) {
			System.out.println(p7.getNome() + " " + p6.getDescricao());
		}
		session.close();
	}

}
