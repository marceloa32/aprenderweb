package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import br.com.caelum.jdbc.TipoBD;
import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteSqlserver {

	public static void main(String[] args) {
		
		ContatoDAO dao = new ContatoDAO(TipoBD.SQLSERVER);
		
		//----- adiciona
		Contato c1 = new Contato();
		c1.setNome("Joao");
		c1.setEmail("joao@email.com");
		Calendar cal1 = Calendar.getInstance();
		cal1.set(1980, Calendar.JANUARY, 1);
		c1.setDataNascimento(cal1);
		c1.setEndereco("Rua da casa do Joao, 1");
		
		Contato c2 = new Contato();
		c2.setNome("Maria");
		c2.setEmail("maria@email.com");
		Calendar cal2 = Calendar.getInstance();
		cal2.set(1981, Calendar.FEBRUARY, 2);
		c2.setDataNascimento(cal2);
		c2.setEndereco("Rua da casa da Maria, 2");
		
		Contato c3 = new Contato();
		c3.setNome("José");
		c3.setEmail("jose@email.com");
		Calendar cal3 = Calendar.getInstance();
		cal3.set(1982, Calendar.MARCH, 3);
		c3.setDataNascimento(cal3);
		c3.setEndereco("Rua da casa do Jose, 3");
		
		Contato c4 = new Contato();
		c4.setNome("Ana");
		c4.setEmail("ana@email.com");
		Calendar cal4 = Calendar.getInstance();
		cal4.set(1983, Calendar.APRIL, 4);
		c4.setDataNascimento(cal4);
		c4.setEndereco("Rua da casa da Ana, 4");
		
		dao.adiciona(c1);
		dao.adiciona(c2);
		dao.adiciona(c3);
		dao.adiciona(c4);

		//---- lista
		listar(dao.getLista());
		
		//----- alterar
		
		Contato ca = dao.pesquisar(4);
		
		if(ca != null) {
			ca.setNome("Joana");
			ca.setEmail("joana@email.com");
			Calendar calA = Calendar.getInstance();
			calA.set(1984, Calendar.MAY, 5);
			ca.setDataNascimento(calA);
			ca.setEndereco("Rua da casa da Joana, 5");
			dao.altera(ca);

			listar(dao.getLista());
		}
		
		//----- deleta o ultimo
		Contato cb = dao.getLista().stream().max(Comparator.comparing(Contato::getId)).orElseThrow(NoSuchElementException::new);
		
		if(cb != null) {
			
			dao.remove(cb);
			listar(dao.getLista());
		}
		
		
	}

	private static void listar(List<Contato> lista) {
		
		System.out.println("----------------------------------------");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		for (Contato contato : lista) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereco: " + contato.getEndereco());
			
			System.out.println("Data de nascimento: " + sdf.format(contato.getDataNascimento().getTime()));
		}
	}
}
