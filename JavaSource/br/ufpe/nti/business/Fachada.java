package br.ufpe.nti.business;

import java.io.Serializable;

public class Fachada implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static Fachada instance;
	private UsuarioBC usuarioBC;
	private LivroBC livroBC;
	private EditoraBC editoraBC;
	private AutorBC autorBC;
	
	public Fachada(){
		this.usuarioBC = new UsuarioBC();
		this.livroBC = new LivroBC();
		this.editoraBC = new EditoraBC();
		this.autorBC = new AutorBC();
	}
	
	public static Fachada getInstance(){
		if (instance == null){
	         instance = new Fachada();
		}
	    return instance;
	}

	public UsuarioBC getUsuarioBC() {
		return usuarioBC;
	}

	public LivroBC getLivroBC() {
		return livroBC;
	}

	public EditoraBC getEditoraBC() {
		return editoraBC;
	}

	public AutorBC getAutorBC() {
		return autorBC;
	}
}
