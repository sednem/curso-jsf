package br.ufpe.nti.ui.jsf.publics;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="publicBean")
@SessionScoped
public class PublicMBean implements Serializable {
	
	private static final long serialVersionUID = -739796634234593363L;
	
	public PublicMBean(){
	}
}
