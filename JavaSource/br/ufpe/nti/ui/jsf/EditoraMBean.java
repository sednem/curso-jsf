package br.ufpe.nti.ui.jsf;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.ufpe.nti.business.EditoraBC;
import br.ufpe.nti.entity.Editora;

@Controller("editoraBean")
@Scope("view")
public class EditoraMBean extends BaseBean{
	
	private static final long serialVersionUID = -3418114936424060328L;
	
	private EditoraBC editoraBC;
	private Editora editora;
	private List<Editora> editoras;
	private int estado;
	
	private static final int ESTADO_LISTAR = 0;
	private static final int ESTADO_CADASTRAR = 1;
	private static final int ESTADO_EDITAR = 2;
	
	@Autowired
	public EditoraMBean(EditoraBC editoraBC){
		this.editoraBC = editoraBC;
		this.estado = ESTADO_LISTAR;
	}
	
	public void cadastrar(ActionEvent al){
		this.editoraBC.inserir(editora);
		addInfoMessage("Editora cadastrado com sucesso.");
		this.telaListar();
	}
	
	public void atualizar(ActionEvent al){
		this.editoraBC.atualizar(editora);
		addInfoMessage("Editora atualizado com sucesso.");
		this.telaListar();
	}
	
	public void remover(ActionEvent al){
		this.editoraBC.excluir(editora);
		addInfoMessage("Editora excluído com sucesso.");
		this.telaListar();
	}
	
	public void telaListar(){
		this.editora = null;
		this.estado = ESTADO_LISTAR;
		this.editoras = null;
	}
	
	public void telaCadastrar(){
		this.estado = ESTADO_CADASTRAR;
		this.editora = new Editora();
	}
	
	public void telaEditar(){
		this.estado = ESTADO_EDITAR;
	}
	
	public boolean isListar(){
		return this.estado == ESTADO_LISTAR;
	}
	
	public boolean isCadastrar(){
		return this.estado == ESTADO_CADASTRAR;
	}
	
	public boolean isEditar(){
		return this.estado == ESTADO_EDITAR;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List<Editora> getEditoras() {
		if(this.editoras == null){
			this.editoras = editoraBC.listar();
		}
		return editoras;
	}

	public void setEditoras(List<Editora> editoras) {
		this.editoras = editoras;
	}
	
	public EditoraBC getEditoraBC() {
		return editoraBC;
	}

	public void setEditoraBC(EditoraBC editoraBC) {
		this.editoraBC = editoraBC;
	}
}
