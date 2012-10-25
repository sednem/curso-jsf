package br.ufpe.nti.ui.jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufpe.nti.business.Fachada;
import br.ufpe.nti.entity.Editora;
import br.ufpe.nti.entity.Livro;

@ManagedBean(name="livroBean")
@ViewScoped
public class LivroMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Livro livro;
	private List<Livro> livros;
	private List<Editora> editoras;
	
	Fachada f = Fachada.getInstance();
	
	public LivroMBean(){
		this.livro = new Livro();
		this.livros = f.getLivroBC().listar();
		this.editoras = f.getEditoraBC().listar();
	}
	
	public String cadastrar(){
		System.out.println(this.livro.getEditora().getNome());
		return "";
	}
	
	//Getters and Setters
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	public List<Editora> getEditoras() {
		return editoras;
	}
	public void setEditoras(List<Editora> editoras) {
		this.editoras = editoras;
	}
}
