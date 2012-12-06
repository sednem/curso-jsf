package br.ufpe.nti.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import br.ufpe.nti.entity.Livro;

@Repository("lDAO")
public class LivroDAO extends GenericDAOImpl<Livro, Long> implements Serializable {
	
	private static final long serialVersionUID = 1689277318301234129L;

	public LivroDAO(){}
}
