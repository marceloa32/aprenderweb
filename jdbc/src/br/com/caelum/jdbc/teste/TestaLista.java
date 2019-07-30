package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

/**
 * FJ-21 14.5.2 exr. 2.13
 * exr 2.15 1
 * 
 */
public class TestaLista {
	
	public static void main(String[] args) {
		
		ContatoDAO dao = new ContatoDAO();
		List<Contato> lista = dao.getLista();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		for (Contato contato : lista) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereco: " + contato.getEndereco());
			
			System.out.println("Data de nascimento: " + sdf.format(contato.getDataNascimento().getTime()));
		}
	}

}
