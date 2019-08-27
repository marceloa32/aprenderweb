package br.com.caelum.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

@SuppressWarnings("deprecation")
public class AdicionaProduto {
	
	public static void main(String[] args) {
		
		Produto p = new Produto();
		p.setNome("Produto 3");
		p.setDescricao("Produto 3");
		p.setPreco(27.08);
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Produto.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		
		System.out.println("ID do produto: " + p.getId());
		
		session.close();
	}

}
