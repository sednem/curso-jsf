package br.ufpe.nti.entity;

import java.io.Serializable;

public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nome;
	
	public Autor(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
