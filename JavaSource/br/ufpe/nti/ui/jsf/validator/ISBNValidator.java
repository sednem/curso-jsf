package br.ufpe.nti.ui.jsf.validator;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="isbnValidator")
public class ISBNValidator implements Validator {

	@Override
	public void validate(FacesContext facesContext, UIComponent component, Object obj)
			throws ValidatorException {
		Collection<FacesMessage> msgs = new ArrayList<FacesMessage>();
		try {
			String isbn = (String) obj;
			
			//Implementação da validação do ISBN
			if(isbn.length() != 13){
				
				FacesMessage msg = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "ISBN incorreto",
						"O ISBN deve conter 13 dígitos numéricos");
				msgs.add(msg);
			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, e.getMessage(),
					e.getCause().getMessage());
			msgs.add(msg);
		}
		
		if(!msgs.isEmpty()){
			throw new ValidatorException(msgs);
		}

	}
}
