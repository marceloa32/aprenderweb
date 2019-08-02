package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

/**
 * FJ-21 14.5.2 exr. 2.17-3
 *
 */
public class TestaAlteracaoRemocao {
	
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		ContatoDAO dao = new ContatoDAO();
		
		Contato c = new Contato();
		c.setNome("Keanu Reeves");
		Calendar dataNasc = Calendar.getInstance();
		dataNasc.set(Calendar.YEAR, 1964);
		dataNasc.set(Calendar.MONTH, Calendar.SEPTEMBER);
		dataNasc.set(Calendar.DAY_OF_MONTH, 2);
		c.setDataNascimento(dataNasc);
		c.setEmail("keanu.reeves@cinema.com");
		c.setEndereco("Nao sei");
		dao.adiciona(c);
		
		//-----
		Contato pesq = dao.pesquisar(4);
		System.out.println("Id: " + pesq.getId());
		System.out.println("Nome: " + pesq.getNome());
		System.out.println("Email: " + pesq.getEmail());
		System.out.println("Endereco: " + pesq.getEndereco());			
		System.out.println("Data de nascimento: " + sdf.format(pesq.getDataNascimento().getTime()));
				
		
		pesq.setNome("Sandra Bullock");		
		dataNasc.set(Calendar.YEAR, 1964);
		dataNasc.set(Calendar.MONTH, Calendar.JULY);
		dataNasc.set(Calendar.DAY_OF_MONTH, 26);
		pesq.setDataNascimento(dataNasc);
		pesq.setEmail("sandra.bullock@cinema.com");
		pesq.setEndereco("Tambem Nao sei");
		
		dao.altera(pesq);
		
		dao.pesquisar(pesq.getId());		
		System.out.println("Id: " + pesq.getId());
		System.out.println("Nome: " + pesq.getNome());
		System.out.println("Email: " + pesq.getEmail());
		System.out.println("Endereco: " + pesq.getEndereco());			
		System.out.println("Data de nascimento: " + sdf.format(pesq.getDataNascimento().getTime()));
		
		dao.remove(pesq);
		
		Contato pesq2 = dao.pesquisar(pesq.getId());
		
		if(pesq2 == null) {
			System.out.println("removido");
		}
		
	}

}
