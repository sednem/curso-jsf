package br.ufpe.nti.business;

import java.io.Serializable;
import java.util.List;

import br.ufpe.nti.dao.EditoraDAO;
import br.ufpe.nti.entity.Editora;

public class EditoraBC implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private EditoraDAO eDAO;

	public EditoraBC(){
		this.eDAO = new EditoraDAO();		
	}
	
	/**
	 * Persiste a editora
	 * @param u Editora a ser persistido
	 */
	public void inserir(Editora u){
		this.eDAO.inserir(u);
	}
	
	/**
	 * Consulta todos as editora cadastradas
	 * @return Lista de Editoras cadastradas
	 */
	public List<Editora> listar(){
		return this.eDAO.listar();
	}
	
	/**
	 * Consulta uma editora pelo ID
	 * @param id da editora desejada
	 * @return Editara que possui o id informado.
	 */
	public Editora consultarPorId(long id){
		return this.eDAO.consultarPorId(id);
	}
}
