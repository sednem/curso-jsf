package br.ufpe.nti.ui.jsf;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.ufpe.nti.business.Fachada;
import br.ufpe.nti.business.UsuarioBC;
import br.ufpe.nti.entity.Usuario;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public LoginMBean(){
		this.usuario = new Usuario();
	}

	public String autenticar(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		UsuarioBC usuarioBC = Fachada.getInstance().getUsuarioBC();
		
		if(usuarioBC.usuarioValido(this.usuario.getLogin(), 
				this.usuario.getSenha())){

			//Adiciona o usuario na sessão
			HttpSession session = (HttpSession) 
					facesContext.getExternalContext().getSession(true);
			this.usuario = usuarioBC.consultarPorLogin(this.usuario.getLogin());
			
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
