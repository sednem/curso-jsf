package br.ufpe.nti.ui.jsf;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.ufpe.nti.business.AutorBC;
import br.ufpe.nti.entity.Autor;

@Controller("autorBean")
@Scope("view")
public class AutorMBean extends BaseBean{
	
	private static final long serialVersionUID = -3418114936424060328L;
	
	private AutorBC autorBC;
	private Autor autor;
	private List<Autor> autores;
	private int estado;
	
	private static final int ESTADO_LISTAR = 0;
	private static final int ESTADO_CADASTRAR = 1;
	private static final int ESTADO_EDITAR = 2;
	
	@Autowired
	public AutorMBean(AutorBC autorBC){
		this.autorBC = autorBC;
		this.estado = ESTADO_LISTAR;
	}
	
	public void cadastrar(ActionEvent al){
		this.autorBC.inserir(autor);
		addInfoMessage("Autor cadastrado com sucesso.");
		this.telaListar();
	}
	
	public void atualizar(ActionEvent al){
		this.autorBC.atualizar(autor);
		addInfoMessage("Autor atualizado com sucesso.");
		this.telaListar();
	}
	
	public void remover(ActionEvent al){
		this.autorBC.excluir(autor);
		addInfoMessage("Autor excluído com sucesso.");
		this.telaListar();
	}
	
	public void telaListar(){
		this.autor = null;
		this.estado = ESTADO_LISTAR;
		this.autores = null;
	}
	
	public void telaCadastrar(){
		this.estado = ESTADO_CADASTRAR;
		this.autor = new Autor();
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

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Autor> getAutores() {
		if(this.autores == null){
			this.autores = autorBC.listar();
		}
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	public AutorBC getAutorBC() {
		return autorBC;
	}

	public void setAutorBC(AutorBC autorBC) {
		this.autorBC = autorBC;
	}
}
