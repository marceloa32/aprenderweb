package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

/**
 * FJ-21 14.5.2 exr. 2.11
 *
 */
public class TestaInsere {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		//gravar nessa conexaqo
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);
		
		System.out.println("Contato gravado!");
	}
}
