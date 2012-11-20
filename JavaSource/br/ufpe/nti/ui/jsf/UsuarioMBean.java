package br.ufpe.nti.ui.jsf;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import br.ufpe.nti.business.Fachada;
import br.ufpe.nti.entity.Usuario;

@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioMBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private String confSenha;
	private ResourceBundle bundle;
	
	private Fachada f = Fachada.getInstance();
	
	//Contrutor do Managed Bean
	public UsuarioMBean(){
		this.usuario = new Usuario();
	}
	
	/**
	 * Cadastrar um novo usuario
	 * @return Outcome da navigation rule
	 */
	public String cadastrar(){	
		String outcome = "";
		
		if(this.validarUsuario(this.usuario, confSenha)){
			f.getUsuarioBC().inserir(usuario);
			
			String msg = this.getValue("cadastrar.usuario.sucesso");
			msg = MessageFormat.format(msg, usuario.getLogin());
			
			FacesMessage facesMsg = new FacesMessage(msg);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);

			this.usuario = new Usuario();
		}
		return outcome;
	}
	
	
	/**
	 * Verifica a disponibilidade de um login
	 * @param e ActionEvent
	 */
	public void verificarDisponibilidadeLogin(ActionEvent e){
		if(existeNomeUsuario(this.getUsuario().getLogin())){
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					this.getValue("cadastrar.usuario.username.indisponivel"), 
					this.getValue("cadastrar.usuario.username.indisponivel"));
			FacesContext.getCurrentInstance().addMessage("usuario", msg);
			
		}else{
			
			FacesMessage msg = new FacesMessage(
					this.getValue("cadastrar.usuario.username.disponivel"));
			FacesContext.getCurrentInstance().addMessage("usuario", msg);
		}		
	}
	
	/**
	 * Excuta quando um valor é alterado
	 * @param ce ValueChangeEvent
	 */
	public void valorAlterado(ValueChangeEvent ce){
		System.out.println();
		System.out.println("Valor anterior: " + ce.getOldValue());
		System.out.println("Valor novo: " + ce.getNewValue());
		System.out.println("Valor login atual: " + this.usuario.getLogin());
		System.out.println();
		
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
			
			FacesMessage msg = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					this.getValue("cadastrar.usuario.erro.confirmacao.senha"),
					this.getValue("cadastrar.usuario.erro.confirmacao.senha"));
			FacesContext.getCurrentInstance().addMessage("senha", msg);
		}
		
		//Verifica se já existe algum usário com o nome informado
		if(this.existeNomeUsuario(u.getLogin())){
			valido = false;
			
			String msg = this.getValue("cadastrar.usuario.erro.username");
			msg = MessageFormat.format(msg, u.getLogin());
			
			FacesMessage facesMsg = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					msg, msg);
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
		for (Usuario usuario : f.getUsuarioBC().listar()) {
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
	
	public String testarMensagem(){
		FacesMessage facesMsg = new FacesMessage("Tete Notify");
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		
		return "";
	}

	//Getters and Setters
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
