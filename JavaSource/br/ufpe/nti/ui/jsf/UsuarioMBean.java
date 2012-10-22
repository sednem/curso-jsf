package br.ufpe.nti.ui.jsf;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ufpe.nti.entity.Usuario;

@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioMBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	private String confSenha;
	private ResourceBundle bundle;
	
	//Contrutor do Managed Bean
	public UsuarioMBean(){
		this.usuario = new Usuario();
		this.usuarios = new ArrayList<Usuario>();
	}
	
	/**
	 * Cadastrar um novo usuario
	 * @return Outcome da navigation rule
	 */
	public String cadastrar(){	
		String outcome = "";
		
		if(this.validarUsuario(this.usuario, confSenha)){
			this.usuarios.add(usuario);
			
			String msg = this.getValue("cadastrar.usuario.sucesso");
			msg = MessageFormat.format(msg, usuario.getLogin());
			
			FacesMessage facesMsg = new FacesMessage(msg);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);

			this.usuario = new Usuario();
			outcome = "sucesso";
		}else {
			outcome = "erro";
		}
		return outcome;
	}
	
	/**
	 * Valida os dados de um novo usuario.
	 * @param u
	 * @param confSenha
	 * @return true se os dados estiverem corretos ou false se os dados estiverem de forma incorreta
	 */
	private boolean validarUsuario(Usuario u, String confSenha){
		boolean valido = true;
		
		//Verifica se o campo senha e confirmação de senha são iguais
		if (!u.getSenha().equals(confSenha)) {
			valido = false;
			
			FacesMessage msg = new FacesMessage(this.getValue("cadastrar.usuario.erro.confirmacao.senha"));
			FacesContext.getCurrentInstance().addMessage("senha", msg);
		}
		
		//Verifica se já existe algum usário com o nome informado
		if(this.existeNomeUsuario(u.getLogin())){
			valido = false;
			
			String msg = this.getValue("cadastrar.usuario.erro.username");
			msg = MessageFormat.format(msg, u.getLogin());
			
			FacesMessage facesMsg = new FacesMessage(msg);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);			
		}
		
		return valido;		
	}

	/**
	 * Verifica se ja existe um usuário cadastrado com o nome informado
	 * @param nomeUsuario Nome do usário
	 * @return true se existir e false se não existir
	 */
	private boolean existeNomeUsuario(String nomeUsuario) {
		boolean existe = false;
		for (Usuario usuario : this.usuarios) {
			if(usuario.getLogin().equals(nomeUsuario)){
				existe = true;
				break;
			}
		}
		return existe;
	}

	/**
	 * Recupera a referencia ao properties menssagens.properties
	 * @return ResourceBundle
	 */
	public ResourceBundle getBundle() {
		if (bundle == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			bundle = context.getApplication().getResourceBundle(context, "msg");
		}
		return bundle;
	}

	/**
	 * Recupera um valor do properties menssagens.properties
	 * @param key
	 * @return Valor da key selecionada
	 */
	public String getValue(String key) {

		String result = null;
		try {
			result = getBundle().getString(key);
		} catch (MissingResourceException e) {
			result = "???" + key + "??? not found";
		}
		return result;
	}

	//Getters and Setters
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getConfSenha() {
		return confSenha;
	}

	public void setConfSenha(String confSenha) {
		this.confSenha = confSenha;
	}

	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}
}
