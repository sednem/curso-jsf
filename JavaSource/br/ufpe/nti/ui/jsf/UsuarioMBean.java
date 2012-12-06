package br.ufpe.nti.ui.jsf;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.ufpe.nti.business.UsuarioBC;
import br.ufpe.nti.entity.Endereco;
import br.ufpe.nti.entity.Usuario;

@Controller("usuarioBean")
@Scope("view")
public class UsuarioMBean extends BaseBean{
	
	private static final long serialVersionUID = -3418114936424060328L;
	
	private UsuarioBC usuarioBC;
	private Usuario usuario;
	private List<Usuario> usuarios;
	private int estado;
	
	private static final int ESTADO_LISTAR = 0;
	private static final int ESTADO_CADASTRAR = 1;
	private static final int ESTADO_EDITAR = 2;
	
	@Autowired
	public UsuarioMBean(UsuarioBC usuarioBC){
		this.usuarioBC = usuarioBC;
		this.estado = ESTADO_LISTAR;
	}
	
	public void cadastrar(ActionEvent al){
		this.usuarioBC.inserir(usuario);
		addInfoMessage("Usuario cadastrado com sucesso.");
		this.telaListar();
	}
	
	public void atualizar(ActionEvent al){
		this.usuarioBC.atualizar(usuario);
		addInfoMessage("Usuario atualizado com sucesso.");
		this.telaListar();
	}
	
	public void remover(ActionEvent al){
		this.usuarioBC.excluir(usuario);
		addInfoMessage("Usuario excluído com sucesso.");
		this.telaListar();
	}
	
	public void telaListar(){
		this.usuario = null;
		this.estado = ESTADO_LISTAR;
		this.usuarios = null;
	}
	
	public void telaCadastrar(){
		this.estado = ESTADO_CADASTRAR;
		this.usuario = new Usuario();
		this.usuario.setEndereco(new Endereco());
	}
	
	public void telaEditar(){
		this.estado = ESTADO_EDITAR;
	}
	
	public boolean isListar(){
		return this.estado == ESTADO_LISTAR;
	}
	
	public boolean isCadastrar(){
		return this.estado == ESTADO_CADASTRAR;
	}
	
	public boolean isEditar(){
		return this.estado == ESTADO_EDITAR;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		if(this.usuarios == null){
			this.usuarios = usuarioBC.listar();
		}
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public UsuarioBC getUsuarioBC() {
		return usuarioBC;
	}

	public void setUsuarioBC(UsuarioBC usuarioBC) {
		this.usuarioBC = usuarioBC;
	}
}
