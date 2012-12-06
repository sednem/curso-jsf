package br.ufpe.nti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="pessoa")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name="TIPO")
@DiscriminatorValue("P")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Size(min=1,message="{validation.campo.obrigatorio}")
	private String cpf;
	
	@Size(min=1,message="{validation.campo.obrigatorio}")
	private String nome;
	
	@Pattern(regexp="^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,6})$")
	private String email;
	
	private String sexo;	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_ENDERECO", nullable=false)
	//@PrimaryKeyJoinColumn
	private Endereco endereco;
	
	@Temporal(value=TemporalType.DATE)
	@NotNull(message="{validation.campo.obrigatorio}")
	private Date dataNascimento;
	
	public Pessoa(){}
	
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
		return this.cpf + ":" + this.nome
				 + ":" + this.email
				 + ":" + this.sexo
				 + ":" + this.dataNascimento
				 + ":" + this.endereco;
	}
	
	/*
	 * Getters and Setters
	 */
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
