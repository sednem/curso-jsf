package br.ufpe.nti.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("U")
public class Usuario extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@Size(min=1,message="{validation.campo.obrigatorio}")
	private String login;
	
	@Size(min=1,message="{validation.campo.obrigatorio}")
	private String senha;
	
	@OneToMany(mappedBy="usuario")
	private List<Compra> compras;
	
	public Usuario(){}
	
	@Override
	public boolean equals(Object obj) {
		
		return toString().equals(obj.toString());
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		return super.toString()
				+ ":" + this.login;
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

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
}
