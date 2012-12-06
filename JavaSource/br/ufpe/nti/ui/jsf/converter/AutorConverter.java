package br.ufpe.nti.ui.jsf.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufpe.nti.business.AutorBC;
import br.ufpe.nti.entity.Autor;

@Component("autorConverter")
public class AutorConverter implements Converter {

	@Autowired
	private AutorBC bc;
	public AutorConverter(){}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String str) {
		
		if(str != null && !str.trim().equals("")){
			
			try {
				Long id = Long.parseLong(str);	
				
				return this.bc.consultarPorId(id);
			} catch (NumberFormatException e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro de conversão do objeto Autor",
						"Não foi possível converter '" + str
						+ "' em um Autor");
				throw new ConverterException(msg);
			}
		}else{
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component,
			Object obj) {
		
		if(obj instanceof Autor){
			Autor a = (Autor) obj;
			return ""+a.getId();
		}else{
			return null;
		}
	}

	public AutorBC getAutorBC() {
		return bc;
	}

	public void setAutorBC(AutorBC autorBC) {
		this.bc = autorBC;
	}

}
