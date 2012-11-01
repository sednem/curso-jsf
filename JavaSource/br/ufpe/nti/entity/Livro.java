package br.ufpe.nti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufpe.nti.entity.beanValidation.ISBN;

public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	@ISBN
	private String isbn; //Deve conter 13 dígitos.
	
	@NotNull(message="{validation.campo.obrigatorio}")
	@Size(min=1,message="{validation.campo.obrigatorio}")
	//private List<Autor> autores;
	private String autor;
	
	@NotNull(message="{validation.campo.obrigatorio}")
	private Editora editora;
	
	@Size(min=1,message="{validation.campo.obrigatorio}")
	private String titulo;
	
	@NotNull(message="{validation.campo.obrigatorio}")
	private Float preco;
	
	@NotNull(message="{validation.campo.obrigatorio}")
	private Date dataPublicacao;
	
	public Livro(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

//	public List<Autor> getAutores() {
//		return autores;
//	}
//
//	public void setAutores(List<Autor> autores) {
//		this.autores = autores;
//	}
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

}
