package br.ufpe.nti.ui.jsf.components;
import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
@FacesComponent(value="HtmlHelloWorld")
public class HtmlHelloWorld extends UIComponentBase {
	@Override
	public String getFamily() {
		return null;
	}
	@Override
	public void encodeAll(FacesContext context) throws IOException {
	  ResponseWriter writer = context.getResponseWriter();
	  writer.startElement("div", this);
	  writer.writeAttribute("style", "color : red", null );
	  writer.writeText( this.getAttributes().get("helloMsg") +  " today is: " +
	                   new java.util.Date(), null);
	  writer.endElement("div");
	}
}
