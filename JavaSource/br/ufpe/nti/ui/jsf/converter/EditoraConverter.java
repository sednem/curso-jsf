package br.ufpe.nti.ui.jsf.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufpe.nti.business.EditoraBC;
import br.ufpe.nti.entity.Editora;

@Component("editoraConverter")
public class EditoraConverter implements Converter {

	@Autowired
	private EditoraBC bc;
	public EditoraConverter(){}
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String str) {
		
		if(str != null && !str.trim().equals("")){
			
			try {
				Long id = Long.parseLong(str);	
				
				Editora ed = this.bc.consultarPorId(id); 
				return ed;
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

	public EditoraBC getEditoraBC() {
		return bc;
	}
	public void setEditoraBC(EditoraBC editoraBC) {
		this.bc = editoraBC;
	}
}
