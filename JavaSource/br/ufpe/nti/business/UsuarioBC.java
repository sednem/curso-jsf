package br.ufpe.nti.business;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpe.nti.dao.UsuarioDAO;
import br.ufpe.nti.entity.Usuario;

@Service("usuarioBC")
public class UsuarioBC implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private UsuarioDAO uDAO;

	public UsuarioBC(){
	}
	
	/**
	 * Persiste o usuário
	 * @param u Usuario a ser persistido
	 */
	public void inserir(Usuario u){
		this.uDAO.insert(u);
	}
	
	/**
	 * Consulta todos os usuário cadastrados
	 * @return Lista de Usuarios cadastrados
	 */
	public List<Usuario> listar(){
		return this.uDAO.findAll();
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

	public void excluir(Usuario usuario) {
		this.uDAO.delete(usuario);
	}

	public void atualizar(Usuario usuario) {
		this.uDAO.update(usuario);
	}
}
