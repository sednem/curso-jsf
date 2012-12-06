package br.ufpe.nti.business;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpe.nti.dao.EditoraDAO;
import br.ufpe.nti.entity.Editora;

@Service("editoraBC")
public class EditoraBC implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private EditoraDAO eDAO;

	public EditoraBC(){
	}
	
	/**
	 * Persiste a editora
	 * @param u Editora a ser persistido
	 */
	public void inserir(Editora u){
		this.eDAO.insert(u);
	}
	
	/**
	 * Consulta todos as editora cadastradas
	 * @return Lista de Editoras cadastradas
	 */
	public List<Editora> listar(){
		return this.eDAO.findAll();
	}
	
	/**
	 * Consulta uma editora pelo ID
	 * @param id da editora desejada
	 * @return Editara que possui o id informado.
	 */
	public Editora consultarPorId(long id){
		return this.eDAO.findByPK(id);
	}

	public void excluir(Editora editora) {
		this.eDAO.delete(editora);
	}

	public void atualizar(Editora editora) {
		this.eDAO.update(editora);
	}
}
