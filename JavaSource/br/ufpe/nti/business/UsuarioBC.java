package br.ufpe.nti.business;

import java.io.Serializable;
import java.util.List;

import br.ufpe.nti.dao.UsuarioDAO;
import br.ufpe.nti.entity.Usuario;

public class UsuarioBC implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private UsuarioDAO uDAO;

	public UsuarioBC(){
		this.uDAO = new UsuarioDAO();
	}
	
	/**
	 * Persiste o usuário
	 * @param u Usuario a ser persistido
	 */
	public void inserir(Usuario u){
		this.uDAO.inserir(u);
	}
	
	/**
	 * Consulta todos os usuário cadastrados
	 * @return Lista de Usuarios cadastrados
	 */
	public List<Usuario> listar(){
		return this.uDAO.listar();
	}
	
	/**
	 * Consulta um usuari pelo login
	 * @param login do Usuario
	 * @return Usuario com o login iformado
	 */
	public Usuario consultarPorLogin(String login){
		return this.uDAO.consultarPorLogin(login);
	}
	
	/**
	 * Valida um usario
	 * @param login do Usuario a ser validado
	 * @param senha do usuario a ser validado
	 * @return true se usuário validado e false em caso contrário
	 */
	public boolean usuarioValido(String login, String senha){
		Usuario u = this.uDAO.consultarPorLogin(login);
		
		if(u != null && u.getSenha().equals(senha)){
			return true;
		}else{
			return false;
		}
	}
}
