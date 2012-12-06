package br.ufpe.nti.ui.jsf;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.ufpe.nti.business.AutorBC;
import br.ufpe.nti.business.EditoraBC;
import br.ufpe.nti.business.LivroBC;
import br.ufpe.nti.entity.Autor;
import br.ufpe.nti.entity.Editora;
import br.ufpe.nti.entity.Livro;

@Controller("livroBean")
@Scope("view")
public class LivroMBean extends BaseBean{
	
	private static final long serialVersionUID = -3418114936424060328L;
	
	private LivroBC livroBC;
	private AutorBC autorBC;
	private EditoraBC editoraBC;
	private Livro livro;
	private List<Livro> livros;
	private List<Autor> autores;
	private List<Editora> editoras;
	private int estado;
	
	private static final int ESTADO_LISTAR = 0;
	private static final int ESTADO_CADASTRAR = 1;
	private static final int ESTADO_EDITAR = 2;
	
	@Autowired
	public LivroMBean(LivroBC livroBC, AutorBC autorBC, EditoraBC editoraBC){
		this.livroBC = livroBC;
		this.autorBC = autorBC;
		this.editoraBC = editoraBC;
		this.estado = ESTADO_LISTAR;
	}
	
	public void cadastrar(ActionEvent al){
		this.livroBC.inserir(livro);
		addInfoMessage("Livro cadastrado com sucesso.");
		this.telaListar();
	}
	
	public void atualizar(ActionEvent al){
		this.livroBC.atualizar(livro);
		addInfoMessage("Livro atualizado com sucesso.");
		this.telaListar();
	}
	
	public void remover(ActionEvent al){
		this.livroBC.excluir(livro);
		addInfoMessage("Livro excluído com sucesso.");
		this.telaListar();
	}
	
	public void telaListar(){
		this.livro = null;
		this.estado = ESTADO_LISTAR;
		this.livros = null;
	}
	
	public void telaCadastrar(){
		this.estado = ESTADO_CADASTRAR;
		this.livro = new Livro();
		this.autores = this.autorBC.listar();
		this.editoras = this.editoraBC.listar();
	}
	
	public void telaEditar(){
		this.estado = ESTADO_EDITAR;
		this.autores = this.autorBC.listar();
		this.editoras = this.editoraBC.listar();
	}
	
	public boolean isListar(){
		return this.estado == ESTADO_LISTAR;
	}
	
	public boolean isCadastro(){
		return this.estado == ESTADO_CADASTRAR;
	}
	
	public boolean isEdicao(){
		return this.estado == ESTADO_EDITAR;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getLivros() {
		if(this.livros == null){
			this.livros = livroBC.listar();
		}
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	public LivroBC getLivroBC() {
		return livroBC;
	}

	public void setLivroBC(LivroBC livroBC) {
		this.livroBC = livroBC;
	}

	public EditoraBC getEditoraBC() {
		return editoraBC;
	}

	public void setEditoraBC(EditoraBC editoraBC) {
		this.editoraBC = editoraBC;
	}

	public List<Editora> getEditoras() {
		return editoras;
	}

	public void setEditoras(List<Editora> editoras) {
		this.editoras = editoras;
	}

	public static int getEstadoListar() {
		return ESTADO_LISTAR;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
}
