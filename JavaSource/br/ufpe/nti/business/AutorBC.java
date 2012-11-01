package br.ufpe.nti.business;

import java.io.Serializable;
import java.util.List;

import br.ufpe.nti.dao.AutorDAO;
import br.ufpe.nti.entity.Autor;

public class AutorBC implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private AutorDAO aDAO;

	public AutorBC(){
		this.aDAO = new AutorDAO();		
	}
	
	/**
	 * Persiste a editora
	 * @param a Autor a ser persistido
	 */
	public void inserir(Autor a){
		this.aDAO.inserir(a);
	}
	
	/**
	 * Consulta todos os autores cadastradas
	 * @return Lista de Autores cadastradas
	 */
	public List<Autor> listar(){
		return this.aDAO.listar();
	}
	
	/**
	 * Consulta um autor pelo ID
	 * @param id do autor desejada
	 * @return Autor que possui o id informado.
	 */
	public Autor consultarPorId(long id){
		return this.aDAO.consultarPorId(id);
	}
}
