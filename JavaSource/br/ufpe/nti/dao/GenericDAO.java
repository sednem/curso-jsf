package br.ufpe.nti.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, I extends Serializable>{

	/**
	 * Persiste um objeto
	 * @param object
	 */
	public void insert(T object);
	
	/**
	 * Remove um objeto
	 * @param object
	 */
	public void delete(T object);
	
	/**
	 * Atualiza um objeto
	 * @param object
	 */
	public T update(T object);
	
	/**
	 * Pesquisa um objeto pelo ID
	 * @param id
	 * @return
	 */
	public T findByPK(I id);
	
	/**
	 * Lista todos os objetos cadastrados
	 * @return List<T>
	 */
	public List<T> findAll();
}
