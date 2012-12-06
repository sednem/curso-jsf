package br.ufpe.nti.business;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpe.nti.dao.LivroDAO;
import br.ufpe.nti.entity.Livro;

@Service("livroBC")
public class LivroBC implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private LivroDAO lDAO;

	public LivroBC(){}
	
	/**
	 * Persiste o livro
	 * @param livro Livro a ser persistido
	 */
	public void inserir(Livro livro){
		this.lDAO.insert(livro);
	}
	
	/**
	 * Consulta todos os livros cadastrados
	 * @return Lista de Livros cadastrados
	 */
	public List<Livro> listar(){
		return this.lDAO.findAll();
	}

	public void editar(Livro livro) throws Exception {
		Livro livroCadastrado = this.lDAO.findByPK(livro.getId());
		if(livroCadastrado != null){
			this.lDAO.update(livro);
		}else{
			throw new Exception("Livro a ser editado não foi encontrado");
		}
	}

	public void excluir(Livro livro) {
		this.lDAO.delete(livro);
	}

	public void atualizar(Livro livro) {
		this.lDAO.update(livro);
	}
}
