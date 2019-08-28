package br.com.caelum.hibernate;

import org.hibernate.Session;

@SuppressWarnings("deprecation")
public class AdicionaProduto {
	
	public static void main(String[] args) {
		
		Produto p = new Produto();
		p.setNome("PROD_4");
		p.setDescricao("Produto 4");
		p.setPreco(28.08);
		
		Session session = new HibernateUtil().getSession();
		
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		
		System.out.println("ID do produto: " + p.getId());
		
		session.close();
	}

}
