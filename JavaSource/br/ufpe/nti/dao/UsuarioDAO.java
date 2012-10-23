package br.ufpe.nti.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.nti.entity.Usuario;
import br.ufpe.nti.util.FormatDate;

public class UsuarioDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<Usuario> usuarios;
	
	public UsuarioDAO(){
		this.usuarios = new ArrayList<Usuario>();
		
		Usuario u1 = new Usuario();
		Usuario u2 = new Usuario();
		
		u1.setLogin("renato");
		u1.setSenha("123");
		u1.setNome("Renato Mendes");
		u1.setSexo("Masculino");
		u1.setDataNascimento(FormatDate.getDate("23/01/1989"));
		u1.setEmail("renato@email.com");
		this.usuarios.add(u1);
		
		u2.setLogin("maria");
		u2.setSenha("asd");
		u2.setNome("Maria José");
		u2.setSexo("Feminino");
		u2.setDataNascimento(FormatDate.getDate("25/05/1985"));
		u2.setEmail("maria@email.com");
		this.usuarios.add(u2);
	}
	
	/**
	 * Persiste o usuário
	 * @param u Usuario a ser persistido
	 */
	public void inserir(Usuario u){
		this.usuarios.add(u);
	}
	
	/**
	 * Consulta todos os usuário cadastrados
	 * @return Lista de Usuarios cadastrados
	 */
	public List<Usuario> listar(){
		return this.usuarios;
	}
	
	/**
	 * Consulta um usuari pelo login
	 * @param login do Usuario
	 * @return Usuario com o login iformado
	 */
	public Usuario consultarPorLogin(String login){
		Usuario usuario = null;
		for (Usuario u : this.usuarios) {
			if(u.getLogin().equals(login)){
				usuario = u;
				break;
			}
		}
		return usuario;
	}
	
}
