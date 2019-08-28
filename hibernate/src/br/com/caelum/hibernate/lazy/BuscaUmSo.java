package br.com.caelum.hibernate.lazy;

import org.hibernate.Session;

import br.com.caelum.hibernate.HibernateUtil;
import br.com.caelum.hibernate.Produto;

public class BuscaUmSo {
	
	public static void main(String[] args) {
		
		//15.6 2 nao faz o select
		Session session = new HibernateUtil().getSession();
		Produto encontrado = (Produto)session.load(Produto.class, 1L);

		//15.6 4 o select e' feito no get
		System.out.println("O select ja foi feito");
		//15.6.3 faz o select
		System.out.println(encontrado.getNome());
		
		//15.6.5
		System.out.println(encontrado.getClass().getName());
	}

}
