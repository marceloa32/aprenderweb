package br.com.caelum.usuario.modelo;

public class Usuario {
	
	private String login;
	private String senha;
	
	public String getSenha() {
		return senha;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return this.login;
	}

}
