package br.ufpe.nti.ui.jsf.publics;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufpe.nti.business.Fachada;
import br.ufpe.nti.entity.Livro;

@ManagedBean(name="livrosBean")
@SessionScoped
public class LivrosMBean implements Serializable {

	private static final long serialVersionUID = -8412657829688905958L;
	
	private Livro livro;
	private List<Livro> livros;
	private int tipoVisualizacao;
	private static final int LISTA = 1;
	private static final int GRADE = 2;
	

	Fachada f = Fachada.getInstance();
	
	public LivrosMBean(){
		this.livro = new Livro();
		this.livros = f.getLivroBC().listar();
		this.tipoVisualizacao = LISTA;
	}
	
	public String selecionarLivro(Livro l){
		this.livro = l;
		
		return "detalhes-livro";
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

	public int getTipoVisualizacao() {
		return tipoVisualizacao;
	}

	public void setTipoVisualizacao(int tipoVisualizacao) {
		this.tipoVisualizacao = tipoVisualizacao;
	}

	public static int getLista() {
		return LISTA;
	}

	public static int getGrade() {
		return GRADE;
	}
}
