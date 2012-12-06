package br.ufpe.nti.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import br.ufpe.nti.entity.Autor;

@Repository("autorDAO")
public class AutorDAO extends GenericDAOImpl<Autor, Long>
	implements Serializable {
	
	private static final long serialVersionUID = -585527184742072584L;

	public AutorDAO(){
	}
}
