package br.ufpe.nti.ui.jsf.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.ufpe.nti.business.EditoraBC;
import br.ufpe.nti.business.Fachada;
import br.ufpe.nti.entity.Editora;

@FacesConverter(forClass=Editora.class)
public class EditoraConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String str) {
		
		if(str != null && !str.trim().equals("")){
			
			try {
				Long id = Long.parseLong(str);
				EditoraBC bc = Fachada.getInstance().getEditoraBC();			
				return bc.consultarPorId(id);
			} catch (NumberFormatException e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro de conversão do objeto Editora",
						"Não foi possível converter '" + str
						+ "' em uma Editora");
				throw new ConverterException(msg);
			}
		}else{
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component,
			Object obj) {
		
		if(obj instanceof Editora){
			Editora ed = (Editora) obj;
			return ""+ed.getId();
		}else{
			return null;
		}
	}

}
