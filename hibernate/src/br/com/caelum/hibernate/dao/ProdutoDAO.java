package br.com.caelum.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.hibernate.Produto;

public class ProdutoDAO {
	
	private Session session;
	
	public ProdutoDAO(Session session) {
		this.session = session;
	}
	
	public void salva(Produto p) {
		this.session.save(p);
	}
	
	public void remove(Produto p) {
		this.session.delete(p);
	}
	
	public Produto procura(Long id) {
		return (Produto) this.session.load(Produto.class, id);
	}
	
	public void atualiza(Produto p) {
		this.session.update(p);
	}
	
	//15.5
	public List<Produto> listaTudo(){
		return this.session.createCriteria(Produto.class).list();
	}
	
	public List<Produto> pagina(int inicio, int quantia){
		return this.session.createCriteria(Produto.class).setMaxResults(quantia)
				                                         .setFirstResult(inicio)
				                                         .list();
	}
	
	public List<Produto> precoMaiorQue(double preco){
		Query query = this.session.createQuery("from Produto where preco > :preco");
		query.setDouble("preco", preco);
		return query.list();
	}

}
