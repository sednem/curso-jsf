package br.ufpe.nti.entity;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private String login;
	private String senha;
	private String nome;
	private String email;
	private String sexo;
	private Date dataNascimento;
	
	public Usuario(){
	}
	
	/*
	 * Getters and Setters
	 */
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
