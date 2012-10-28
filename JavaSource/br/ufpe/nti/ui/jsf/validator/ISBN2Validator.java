package br.ufpe.nti.ui.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ISBN2Validator implements Validator {

	@Override
	public void validate(FacesContext facesContext, UIComponent component, Object obj)
			throws ValidatorException {
		
		if(obj.toString().trim().length() != 13){
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"ISBN inválido", "ISBN deve conter 13 caractéres numéricos");
			
			throw new ValidatorException(msg);
		}
	}

}
