package br.ufpe.nti.ui.jsf;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="loginBean")
public class LoginMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String senha;

	public LoginMBean(){

	}

	public String autenticar(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if(this.login.equals("Renato")
				&& this.senha.equals("Qwert123")){

			//Adiciona o usuario na sessão
			HttpSession session = (HttpSession) 
					facesContext.getExternalContext().getSession(true);
			session.setAttribute("currentUser", "Renato");

			return "home";
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

		return "loginPage";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
