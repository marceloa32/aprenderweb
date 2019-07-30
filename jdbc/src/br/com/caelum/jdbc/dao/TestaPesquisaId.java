package br.com.caelum.jdbc.dao;

import java.text.SimpleDateFormat;

import br.com.caelum.jdbc.modelo.Contato;

/**
 * 
 * FJ-21 14.5.2 exr. 2.15-4
 *
 */
public class TestaPesquisaId {
	
	public static void main(String[] args) {
		
		ContatoDAO dao = new ContatoDAO();
		int id = 2;
		Contato contato = dao.pesquisar(id);
		
		if(contato == null) {
			System.out.printf("contato id = %d nao localizado\n", id);
		} else { 
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereco: " + contato.getEndereco());			
			System.out.println("Data de nascimento: " + sdf.format(contato.getDataNascimento().getTime()));
		}
		
	}
	

}
