package br.com.fj21.produto.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.fj21.produto.modelo.Produto;

public class ProdutoDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	public void gravar(Produto p) {
		this.getSession().beginTransaction();
		this.getSession().save(p);
		this.getSession().getTransaction().commit();
	}
	
	private Session getSession() {
		if(this.session == null) {
			session = new HibernateUtil().getSession();
		}			
		return this.session;
	}

	public void remover(Produto p) {
		this.getSession().beginTransaction();
		this.getSession().delete(p);
		this.getSession().getTransaction().commit();
	}	
	
	public Produto pesquisar(Long id) {
		return (Produto) this.getSession().load(Produto.class, id);
	}
	
	public void atualizar(Produto p) {
		this.getSession().beginTransaction();
		this.getSession().update(p);
		this.getSession().getTransaction().commit();
	}
	
	public List<Produto> getLista(){
		return this.getSession().createCriteria(Produto.class).list();
	}
}
