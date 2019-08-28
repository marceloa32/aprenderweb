package br.com.caelum.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Session;

@SuppressWarnings("deprecation")
public class CarregaProduto {
	
	public static void main(String[] args) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Produto.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Produto produto = (Produto) session.load(Produto.class, 3L);
		System.out.println("Nome do produto: " + produto.getNome());
		
		session.close();
	}

}
