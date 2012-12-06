package br.ufpe.nti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import br.ufpe.nti.entity.beanValidation.ISBN;

@Entity
@Table(name="livro")
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ISBN
	private String isbn; //Deve conter 13 dígitos.	
	
	@NotNull(message="{validation.campo.obrigatorio}")
	@ManyToMany
	@JoinTable( name = "livro_autor",
    	joinColumns = {@JoinColumn(name = "id_livro")}, 
    	inverseJoinColumns = {@JoinColumn(name = "id_autor")})  
	private List<Autor> autores;
	
	@ManyToOne
	@JoinColumn(name="ID_EDITORA", nullable=false)
	@NotNull(message="{validation.campo.obrigatorio}")
	private Editora editora;
	
	@Size(min=1,message="{validation.campo.obrigatorio}")
	private String titulo;
	
	@NotNull(message="{validation.campo.obrigatorio}")
	@Range(min=0L, max=999L,
		message="O valor informado deve ser entre 0 e 999")
	private Float preco;
	
	@Temporal(value=TemporalType.DATE)
	@NotNull(message="{validation.campo.obrigatorio}")
	private Date dataPublicacao;
	
	public Livro(){}
	
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
		return this.id + ":" + this.isbn
				 + ":" + this.titulo
				 + ":" + this.preco
				 + ":" + this.dataPublicacao
				 + ":{" + this.autores + "}"
				 + ":{" + this.editora + "}";
	}

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

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
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
