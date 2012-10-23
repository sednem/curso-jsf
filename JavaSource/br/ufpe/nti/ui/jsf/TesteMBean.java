package br.ufpe.nti.ui.jsf;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="testeBean")
@SessionScoped
public class TesteMBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date data = new Date(System.currentTimeMillis());
	private Double numero = new Double(1254321L);
	
	//Contrutor do Managed Bean
	public TesteMBean(){
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public Double getNumero() {
		return numero;
	}

	public void setNumero(Double numero) {
		this.numero = numero;
	}
}
