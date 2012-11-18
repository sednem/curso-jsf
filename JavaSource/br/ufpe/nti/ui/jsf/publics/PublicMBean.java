package br.ufpe.nti.ui.jsf.publics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="publicBean")
@SessionScoped
public class PublicMBean implements Serializable {
	
	private static final long serialVersionUID = -739796634234593363L;
	private String theme;
	private List<String> themes;
	
	public PublicMBean(){
		this.themes = new ArrayList<String>();
		this.themes.add("default");
		this.themes.add("bootstrap");
		this.themes.add("bootstrap-red");
		
		this.theme = this.themes.get(0);
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public List<String> getThemes() {
		return themes;
	}

	public void setThemes(List<String> themes) {
		this.themes = themes;
	}
	
}
