package br.ufpe.nti.dao;

import java.io.Serializable;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufpe.nti.entity.Usuario;

@Repository("usuarioDAO")
public class UsuarioDAO extends GenericDAOImpl<Usuario, Long>
	implements Serializable {

	private static final long serialVersionUID = -2115103114118557656L;

	public UsuarioDAO(){
	}
	
	/**
	 * Consulta um usuari pelo login
	 * @param login do Usuario
	 * @return Usuario com o login iformado
	 */
	public Usuario consultarPorLogin(String login){
		Usuario usuario = null;
		String jpql = "select this from Usuario this WHERE this.login = :login"; 
		Query q = this.getEntityManager().createQuery(jpql); 
		q.setParameter("login", login);		
		try {
			usuario = (Usuario) q.getSingleResult();	
		} catch (NoResultException e) {
			usuario = null;
		}
		
		return usuario;
	}	
}