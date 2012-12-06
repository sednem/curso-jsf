package br.ufpe.nti.ui.jsf;

import java.io.Serializable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class BaseBean implements Serializable{
	
	private static final long serialVersionUID = -4843201867418395323L;
	private ResourceBundle bundle;
	
	protected void addErrorMessage(String componentId, String errorMessage){
		addMessage(componentId, errorMessage, FacesMessage.SEVERITY_ERROR);
	}
	
	protected void addErrorMessage(String errorMessage){
		addErrorMessage(null, errorMessage);
	}
	
	protected void addInfoMessage(String componentId, String infoMessage){
		addMessage(componentId, infoMessage, FacesMessage.SEVERITY_INFO);
	}
	
	protected void addInfoMessage(String infoMessage){
		addInfoMessage(null, infoMessage);
	}
	
	private void addMessage(String componentId, 
			String errorMessage, Severity severity){
		FacesMessage message =  new FacesMessage(errorMessage);
		message.setSeverity(severity);
		FacesContext.getCurrentInstance().addMessage(componentId, message);
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
}