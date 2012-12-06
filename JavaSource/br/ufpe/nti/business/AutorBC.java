package br.ufpe.nti.business;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpe.nti.dao.AutorDAO;
import br.ufpe.nti.entity.Autor;

@Service("autorBC")
public class AutorBC implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private AutorDAO autorDAO;

	public AutorBC(){
	}
	
	/**
	 * Persiste a editora
	 * @param a Autor a ser persistido
	 */
	public void inserir(Autor a){
		this.autorDAO.insert(a);
	}
	
	/**
	 * Consulta todos os autores cadastradas
	 * @return Lista de Autores cadastradas
	 */
	public List<Autor> listar(){
		return this.autorDAO.findAll();
	}
	
	/**
	 * Consulta um autor pelo ID
	 * @param id do autor desejada
	 * @return Autor que possui o id informado.
	 */
	public Autor consultarPorId(long id){
		return this.autorDAO.findByPK(id);
	}

	public void excluir(Autor autor) {
		this.autorDAO.delete(autor);
	}

	public void atualizar(Autor autor) {
		this.autorDAO.update(autor);
	}
}
