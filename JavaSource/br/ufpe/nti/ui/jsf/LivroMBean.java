package br.ufpe.nti.ui.jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.richfaces.component.UIExtendedDataTable;

import br.ufpe.nti.business.Fachada;
import br.ufpe.nti.entity.Editora;
import br.ufpe.nti.entity.Livro;

@ManagedBean(name="livroBean")
@SessionScoped
public class LivroMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final int ESTADO_CADASTRAR = 1;
	private static final int ESTADO_EDITAR = 2;
	
	private static final String PATH_XHTML = "cadastrar";
	
	
	private Livro livro;
	private List<Livro> livros;
	private List<Editora> editoras;
	private int estado;
	
	Fachada f = Fachada.getInstance();
	
	public LivroMBean(){
		this.livro = new Livro();
		this.livros = f.getLivroBC().listar();
		this.editoras = f.getEditoraBC().listar();
		this.estado = ESTADO_CADASTRAR;
	}
	
	/**
	 * Cadastra um novo livro
	 * @return String para regra de navegação
	 */
	public String cadastrar(){
		this.f.getLivroBC().inserir(this.livro);
		return "listar";
	}
	
	/**
	 * Etualiza um  livro
	 * @return String para regra de navegação
	 */
	public String editar(){
		System.out.println("Editar");
		try {
			this.f.getLivroBC().editar(this.livro);
			return "listar";
		} catch (Exception e) {
			FacesMessage msg = 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, msg);			
			
			System.out.println(msg);
			return "";
		}
	}
	
	/**
	 * Prepara a tela para o cadastro
	 * @return Path da tela de cadastro
	 */
	public String telaCadastrar(){
		this.livro = new Livro();
		this.estado = ESTADO_CADASTRAR;
		return PATH_XHTML;
	}
	
	/**
	 * Prepara a tela para a edição
	 * @return Path da tela de edição
	 */
	public String telaEditar(){
		this.estado = ESTADO_EDITAR;
		return PATH_XHTML;
	}
	
	/**
	 * Altera o livro selecionado
	 * @param event de seleção de livro
	 */
	public void selectionListener(AjaxBehaviorEvent event) {
		if(event.getComponent() instanceof UIExtendedDataTable){
			System.out.println("instanceof UIExtendedDataTable");
		}
		UIExtendedDataTable dataTable = (UIExtendedDataTable) event.getComponent();
        Object originalKey = dataTable.getRowKey();
        
        System.out.println(originalKey);
        
    }
	
	/**
	 * Verifica se está no estado CADASTRAR
	 * @return true ou false
	 */
	public boolean isAcaoCadastrar(){
		return this.estado == ESTADO_CADASTRAR;
	}

	/**
	 * Verifica se está no estado EDITAR
	 * @return true ou false
	 */
	public boolean isAcaoEditar(){
		return this.estado == ESTADO_EDITAR;
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
