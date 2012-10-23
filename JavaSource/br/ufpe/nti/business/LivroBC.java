package br.ufpe.nti.business;

import java.io.Serializable;
import java.util.List;

import br.ufpe.nti.dao.LivroDAO;
import br.ufpe.nti.entity.Livro;

public class LivroBC implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private LivroDAO lDAO;

	public LivroBC(){
		this.lDAO = new LivroDAO();		
	}
	
	/**
	 * Persiste o livro
	 * @param u Livro a ser persistido
	 */
	public void inserir(Livro u){
		u.setId(this.listar().size() + 1); //Incrementa o Id
		this.lDAO.inserir(u);
	}
	
	/**
	 * Consulta todos os livros cadastrados
	 * @return Lista de Livros cadastrados
	 */
	public List<Livro> listar(){
		return this.lDAO.listar();
	}
}
