package br.com.caelum.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Produto.class);
		
		factory = cfg.buildSessionFactory();
	}	
	
	public Session getSession() {
		return factory.openSession();
	}

}
