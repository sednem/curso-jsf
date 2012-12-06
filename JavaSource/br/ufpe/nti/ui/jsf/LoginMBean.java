package br.ufpe.nti.ui.jsf;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.ufpe.nti.business.UsuarioBC;
import br.ufpe.nti.entity.Usuario;

@Controller("loginBean")
@Scope("view")
public class LoginMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private UsuarioBC usuarioBC;
	private Usuario usuario;

	@Autowired
	public LoginMBean(UsuarioBC usuarioBC){
		this.usuarioBC = usuarioBC;
		this.usuario = new Usuario();
	}

	public String autenticar(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if(this.usuarioBC.usuarioValido(this.usuario.getLogin(), 
				this.usuario.getSenha())){

			//Adiciona o usuario na sessão
			HttpSession session = (HttpSession) 
					facesContext.getExternalContext().getSession(true);
			this.usuario = this.usuarioBC.consultarPorLogin(this.usuario.getLogin());
			
			session.setAttribute("currentUser", this.usuario);

			return "index";
		}else{
			FacesMessage msg = 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							"Usuário ou senha inválidos", null);
			facesContext.addMessage(null, msg);
			return "";
		}
	}

	public String sair(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = 
				(HttpSession) facesContext.getExternalContext().getSession(true);
		session.invalidate();
		
		this.usuario = new Usuario();
		
		return "loginPage";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
