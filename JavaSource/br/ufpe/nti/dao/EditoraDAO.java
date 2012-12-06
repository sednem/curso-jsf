package br.ufpe.nti.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import br.ufpe.nti.entity.Editora;

@Repository("eDAO")
public class EditoraDAO extends GenericDAOImpl<Editora, Long> implements Serializable{
		
	private static final long serialVersionUID = 106129466229111236L;

	public EditoraDAO(){
	}
}
